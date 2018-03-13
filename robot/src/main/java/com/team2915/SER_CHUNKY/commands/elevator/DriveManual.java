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
    Robot.elevator.setSpeed(Robot.io.getElevatorThrottle());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
}
