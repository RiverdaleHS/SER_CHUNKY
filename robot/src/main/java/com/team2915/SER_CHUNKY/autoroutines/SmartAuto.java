package com.team2915.SER_CHUNKY.autoroutines;


import com.team2915.SER_CHUNKY.commands.Wait;
import com.team2915.SER_CHUNKY.commands.elevator.DriveTimeBased;
import com.team2915.SER_CHUNKY.commands.intake.InitialAutoEjectCube;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SmartAuto extends CommandGroup {

  public SmartAuto(FieldPosition robotPosition, FieldPosition switchPosition,
      FieldPosition scalePosition, AutoType autoType, double timeDelay) {

    addSequential(new Wait(timeDelay));
    if ((robotPosition == FieldPosition.LEFT_SWITCH || robotPosition == FieldPosition.RIGHT_SWITCH) && autoType == AutoType.PLACE_ONE) {
      addSequential(new DriveToSwitch());
      if (robotPosition == switchPosition) {
        addSequential(new DriveTimeBased(0.4, 0.5));
        addSequential(new InitialAutoEjectCube());
      }
    }
    //Scale
    if ((robotPosition == FieldPosition.LEFT_SCALE || robotPosition == FieldPosition.RIGHT_SCALE) && autoType == AutoType.PLACE_ONE) {
      addSequential(new DriveToScale());
      if (robotPosition == scalePosition) {
        addSequential(new DriveTimeBased(0.4, 0.5));
        addSequential(new InitialAutoEjectCube());
      }
    }

    if (autoType == AutoType.LINE_CROSS) {
      addSequential(new DriveTimeBased(0.4, 0.5));
      addSequential(new DriveToAutoLine());
    }

    if (autoType == AutoType.PLACE_TWO && robotPosition == FieldPosition.CENTER_SWITCH){
      addSequential(new );
    }

  }

  public enum FieldPosition {
    LEFT_SCALE,
    LEFT_SWITCH,
    CENTER_SWITCH,
    RIGHT_SCALE,
    RIGHT_SWITCH,
  }

  public enum AutoType {
    PLACE_ONE,
    PLACE_TWO,
    LINE_CROSS,
    DO_NOTHING
  }
}
