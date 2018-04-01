package com.team2915.SER_CHUNKY.commands.chassis;

import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveChassisTimeBassed extends Command {

    double mSpeed;
    double mTime;

    long startTime;

    boolean isStarted = false;


    public DriveChassisTimeBassed(double speed, double time) {
      requires(Robot.chassis);
      mSpeed = speed;
      mTime = time;
    }

    @Override
    protected void execute() {
      super.execute();
      if (isStarted == false){
        startTime = System.currentTimeMillis();//TODO: TEST
        isStarted = true;
      }
      Robot.chassis.setSpeed(mSpeed, mSpeed);
    }



    @Override
    protected boolean isFinished() {
      if (System.currentTimeMillis() >= startTime + mTime) {
        return true;
      }
      return false;
    }
    @Override
    protected void end() {
      super.end();
      Robot.chassis.setSpeed(0, 0);
    }

  }
