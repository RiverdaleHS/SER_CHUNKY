package com.team2915.SER_CHUNKY.autoroutines;


import com.team2915.SER_CHUNKY.commands.Wait;
import com.team2915.SER_CHUNKY.commands.elevator.DriveTimeBased;
import com.team2915.SER_CHUNKY.commands.intake.InitialAutoEjectCube;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SmartAuto extends CommandGroup {

  public SmartAuto(FieldPosition robotPosition, FieldPosition switchPosition,
      FieldPosition scalePosition, double timeDelay) {

    addSequential(new Wait(timeDelay));
    //Switch
    if (robotPosition == FieldPosition.LEFT_SWITCH || robotPosition == FieldPosition.RIGHT_SWITCH) {
      addSequential(new DriveToSwitch());
      if (robotPosition == switchPosition) {
        //TODO: add time based elevator raise
        addSequential(new InitialAutoEjectCube());
      }
    }
    //Scale
    if (robotPosition == FieldPosition.LEFT_SCALE || robotPosition == FieldPosition.RIGHT_SCALE) {
      addSequential(new DriveToScale());
      if (robotPosition == scalePosition) {
        addSequential(new DriveTimeBased(0.4, 0.5));
        addSequential(new InitialAutoEjectCube());
      }
    }

    if (robotPosition == FieldPosition.LINE_CROSS) {
      addSequential(new DriveTimeBased(0.4, 0.5));
      addSequential(new DriveToAutoLine());
    }
  }

  public enum FieldPosition {
    LEFT_SCALE,
    LEFT_SWITCH,
    CENTER_SWITCH,
    RIGHT_SCALE,
    RIGHT_SWITCH,
    LINE_CROSS,
    DO_NOTHING
  }
}
