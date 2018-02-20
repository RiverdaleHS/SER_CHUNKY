package com.team2915.SER_CHUNKY.commands.chassis;

import com.team2915.SER_CHUNKY.Robot;
import com.team2915.SER_CHUNKY.util.Logger;
import edu.wpi.first.wpilibj.command.Command;
import java.util.Date;

public class Characterize extends Command {

  private double speed = 0;

  public Characterize() {
    requires(Robot.chassis);
    Logger.logCSV("MotionProfileCharacterization.csv",
        "avgLeftOutputVoltage, avgRightOutputVoltage, leftEncoderRate, rightEncoderRate, timestamp");
  }


  @Override
  protected void execute() {
    super.execute();
//    if (Robot.io.getCharacterizeAddPower()) {
//      speed += 0.05;
//    }
//    if (Robot.io.getCharacterizeLowerPower()) {
//      speed -= 0.05;
//    }
//    if (Robot.io.getCharacterizeLog()) {
//      Logger.logCSV("MotionProfileCharacterization.csv",
//          Robot.chassis.getAverageLeftVoltage() + " , " + Robot.chassis.getAverageRightVoltage()
//              + " , " + Robot.chassis.getLeftEncoderRate() + " , " + Robot.chassis
//              .getRightEncoderRate() + " , " + new Date());
//    }
//
//    Robot.chassis.setSpeed(speed, speed);
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
    super.end();
    Robot.chassis.setSpeed(0, 0);
  }
}
