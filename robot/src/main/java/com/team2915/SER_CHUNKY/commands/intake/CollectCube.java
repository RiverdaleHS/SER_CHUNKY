package com.team2915.SER_CHUNKY.commands.intake;

import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CollectCube extends Command {

  public CollectCube() {
    requires(Robot.intake);
  }

  @Override
  protected void execute() {
    super.execute();
    if (Robot.intake.getCubeDistanceInches() > 10) {
      Robot.intake.setOpen();
      Robot.intake.setFront(0.5);
      Robot.intake.setRear(0.5);
    } else if (Robot.intake.getCubeDistanceInches() < 10) {
      Robot.intake.setClosed();
      Robot.intake.setFront(0.5);
      Robot.intake.setRear(0.5);
    }
  }

  @Override
  protected boolean isFinished() {
    if (Robot.intake.getCubeDistanceInches() < 1) {
      return true;
    }
    return false;
  }
}
