package com.team2915.SER_CHUNKY.commands.intake;

import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class HoldCube extends Command {

  public HoldCube() {
    requires(Robot.intake);
  }

  @Override
  protected void execute() {
    super.execute();
//    Robot.intake.setClosed();
//    if (Robot.intake.getCubeDistanceInches() > 3 && Robot.intake.getCubeDistanceInches() < 10) {
//      Robot.intake.setFront(0.3);
//      Robot.intake.setRear(0.3);
//    } else {
      Robot.intake.setFront(0);
      Robot.intake.setRear(0);
//    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
}
