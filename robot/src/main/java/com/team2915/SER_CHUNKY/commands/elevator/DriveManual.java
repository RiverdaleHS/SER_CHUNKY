package com.team2915.SER_CHUNKY.commands.elevator;

import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveManual extends Command {

  public DriveManual() {
    requires(Robot.elevator);
  }

  @Override
  protected void execute() {
    super.execute();
    //TODO: get limit switches actually working
//    if (!Robot.elevator.isUp() || !Robot.elevator.isDown()) {
//      if (Math.abs(Robot.io.getElevatorThrottle()) > 0.02) {
//
//      } else {
//        Robot.elevator.setSpeed(0);
//      }
//    }else {
//      Robot.elevator.setSpeed(0);
//    }
    Robot.elevator.setSpeed(Robot.io.getElevatorThrottle());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
}
