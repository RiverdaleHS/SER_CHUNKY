package com.team2915.SER_CHUNKY.autoroutines;


import com.team2915.SER_CHUNKY.commands.elevator.DriveTimeBased;
import com.team2915.SER_CHUNKY.commands.intake.EjectCube;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SmartAuto extends CommandGroup {

  public SmartAuto(FieldPosition robotPosition, FieldPosition switchPosition,
      FieldPosition scalePosition, AutoType autoType, double timeDelay) {
    //TODO: add time delay
    switch (autoType) {
      case LINE_CROSS:
        addSequential(new DriveToAutoLine());
        break;
      case PLACE_ONE:
        switch (robotPosition) {
          case CENTER_SWITCH:
            addSequential(new DriveCurvedSwitch(switchPosition));
            addSequential(new DriveTimeBased(0.3, 0.5));
            addSequential(new EjectCube());
            break;
          case LEFT_SWITCH:
            addSequential(new DriveToSwitch());
            if (switchPosition == FieldPosition.LEFT_SWITCH) {
              addSequential(new DriveTimeBased(0.3, 0.5));
              addSequential(new EjectCube());
            }
            break;
          case RIGHT_SWITCH:
            addSequential(new DriveToSwitch());
            if (switchPosition == FieldPosition.LEFT_SWITCH) {
              addSequential(new DriveTimeBased(0.3, 0.5));
              addSequential(new EjectCube());
            }
            break;
        }
        break;
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
