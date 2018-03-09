package com.team2915.SER_CHUNKY.autoroutines;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class SmartAuto extends CommandGroup {

  public SmartAuto(FieldPosition robotPosition, FieldPosition switchPosition,
      FieldPosition scalePosition, AutoType autoType, double timeDelay) {

    if (autoType == AutoType.LINE_CROSS) {
      addSequential(new DriveToAutoLine());
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
