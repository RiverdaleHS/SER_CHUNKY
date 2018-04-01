package com.team2915.SER_CHUNKY.autoroutines;


import com.team2915.SER_CHUNKY.commands.Wait;
import com.team2915.SER_CHUNKY.commands.chassis.DriveChassisTimeBassed;
import com.team2915.SER_CHUNKY.commands.elevator.DriveTimeBased;
import com.team2915.SER_CHUNKY.commands.intake.EjectCube;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SmartAuto extends CommandGroup {

  public SmartAuto(FieldPosition robotPosition, FieldPosition switchPosition,
      FieldPosition scalePosition, AutoType autoType, double timeDelay, boolean profiled) {

    addSequential(new Wait(timeDelay));

    if (profiled) {
      addParallel(new DriveToAutoLine());
    }else{
      addParallel(new DriveChassisTimeBassed(0.36, 2150));
    }

//    if (profiled) {
//      switch (autoType) {
//        case LINE_CROSS:
//
//          break;
//        case PLACE_ONE:
//          switch (robotPosition) {
//            case CENTER_SWITCH:
//              addSequential(new DriveCurvedSwitch(switchPosition));
//              addParallel(new DriveTimeBased(-1, 1000));
//              addSequential(new EjectCube());
//              break;
//            case LEFT_SWITCH:
//              addSequential(new DriveToSwitch());
//              if (switchPosition == FieldPosition.LEFT_SWITCH) {
//                addParallel(new DriveTimeBased(-1, 1000));
//                addSequential(new EjectCube());
//              }
//              break;
//            case RIGHT_SWITCH:
//              addSequential(new DriveToSwitch());
//              if (switchPosition == FieldPosition.LEFT_SWITCH) {
//                addParallel(new DriveTimeBased(-1, 1000));
//                addSequential(new EjectCube());
//              }
//              break;
//          }
//          break;
//      }
//    }else{
//      addParallel(new DriveChassisTimeBassed(0.45, 2000));
//    }




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
