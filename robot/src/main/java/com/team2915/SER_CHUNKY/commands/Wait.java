package com.team2915.SER_CHUNKY.commands;


import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command {

  long startTime;
  double mTime;


  public Wait(double time) {
    mTime = time;
  }


  @Override
  protected void execute() {
    super.execute();
  }

  @Override
  public synchronized void start() {
    super.start();
    startTime = System.currentTimeMillis();
  }

  @Override
  protected boolean isFinished() {
    if (System.currentTimeMillis() >= startTime + mTime) {
      return true;
    }
    return false;
  }
}
