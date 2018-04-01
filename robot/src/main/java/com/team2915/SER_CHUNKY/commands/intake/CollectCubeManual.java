package com.team2915.SER_CHUNKY.commands.intake;

import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CollectCubeManual extends Command {

  long timeOfLowThreshold;

  public CollectCubeManual() {
    requires(Robot.intake);
  }

  @Override
  protected void execute() {
    super.execute();
    if (Robot.io.getPinchCube()){
      Robot.intake.setClosed();
      Robot.intake.setFront(1);
      Robot.intake.setRear(0.9);
    } else {
      Robot.intake.setOpen();
      Robot.intake.setFront(1);
      Robot.intake.setRear(0.9);
    }
  }

  @Override
  public synchronized void start() {
    super.start();
    Robot.intake.setOpen();
  }

  @Override
  protected boolean isFinished() {
//    if (Robot.intake.getCubeDistanceInches() < 2 && timeOfLowThreshold == 0) {
//      timeOfLowThreshold = System.currentTimeMillis();
//    }
//    if (timeOfLowThreshold + 100 <= System.currentTimeMillis()
//        && Robot.intake.getCubeDistanceInches() < 2) {
//      timeOfLowThreshold = 0;
//      return true;
//    }
    if (Robot.io.getEndIntake()){
      return true;
    }

    return false;
  }
}
