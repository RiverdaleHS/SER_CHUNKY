package com.team2915.SER_CHUNKY.commands.elevator;

import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTimeBased extends Command {

  double mSpeed;
  double mTime;

  public DriveTimeBased(double speed, double time){
    mSpeed = speed;
    mTime = time;
  }

  @Override
  protected void execute() {
    super.execute();
    Robot.elevator.setSpeed(mSpeed);
  }

  @Override
  protected boolean isFinished()
  {
    return true;
  }

  @Override
  protected void end() {
    super.end();
    Robot.elevator.setSpeed(0);
  }
}
