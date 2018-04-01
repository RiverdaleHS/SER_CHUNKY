package com.team2915.SER_CHUNKY.commands.chassis;

import com.team254.frc2016.CheesyDriveHelper;
import com.team254.lib.util.DriveSignal;
import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveOpenLoop extends Command {

  CheesyDriveHelper cheesyDriveHelper = new CheesyDriveHelper();

  public DriveOpenLoop() {
    requires(Robot.chassis);
  }

  @Override
  protected void execute() {
    super.execute();
    DriveSignal ds = cheesyDriveHelper
        .cheesyDrive(-Robot.io.getThrottle(), Robot.io.getTurn(), Robot.io.getQuickTurn());

    if (Robot.io.getShiftLow()) {
      Robot.chassis.shiftLow();
    } else {
      Robot.chassis.shiftHigh();
    }

    Robot.chassis.setSpeed(ds.leftMotor, ds.rightMotor);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    super.end();
    Robot.chassis.setSpeed(0,0);
  }
}
