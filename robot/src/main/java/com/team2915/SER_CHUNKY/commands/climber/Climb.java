package com.team2915.SER_CHUNKY.commands.climber;

import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {

  public Climb() {
    requires(Robot.climber);
  }


  @Override
  protected void execute() {
    super.execute();
    if (Robot.io.getClimb()){
      Robot.climber.setClimber(-1);
    }else {
      Robot.climber.setClimber(0);
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
}
