package com.team2915.SER_CHUNKY.commands.chassis;

import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveOpenLoop extends Command{

  public DriveOpenLoop(){
    requires(Robot.chassis);
  }

  @Override
  protected void execute() {
    super.execute();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
}
