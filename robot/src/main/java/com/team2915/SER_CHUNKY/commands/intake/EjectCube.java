package com.team2915.SER_CHUNKY.commands.intake;

import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class EjectCube extends Command {

  public EjectCube() {
    requires(Robot.intake);
  }

  @Override
  protected void execute() {
    super.execute();
    if (Robot.intake.getCubeDistanceInches() < 2) {
      Robot.intake.setRear(-0.8);
      Robot.intake.setFront(-0.8);
    } else {
      Robot.intake.setFront(-0.4);
      Robot.intake.setRear(-0.4);
      Robot.intake.setOpen();
    }
  }

  @Override
  protected boolean isFinished() {
    if (Robot.intake.getCubeDistanceInches() > 13) {
      return true;
    }
    return false;
  }
}
