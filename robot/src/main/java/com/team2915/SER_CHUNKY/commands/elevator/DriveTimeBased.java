package com.team2915.SER_CHUNKY.commands.elevator;

import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTimeBased extends Command {

  double mSpeed;
  double mTime;

  long startTime;


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
  public synchronized void start() {
    super.start();
    startTime = System.currentTimeMillis();
  }

  @Override
  protected boolean isFinished()
  {
    if (System.currentTimeMillis() >= startTime + mTime){
      return true;
    }
    return false;
  }

  @Override
  protected void end() {
    super.end();
    Robot.elevator.setSpeed(0);
  }
}
