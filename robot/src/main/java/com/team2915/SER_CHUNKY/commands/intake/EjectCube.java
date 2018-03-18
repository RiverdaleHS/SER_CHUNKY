package com.team2915.SER_CHUNKY.commands.intake;

import com.team2915.SER_CHUNKY.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class EjectCube extends Command {

  public EjectCube() {
    requires(Robot.intake);

  }

  @Override
  protected void execute() {
    super.execute();
    Robot.intake.setFront(-0.8);
    Robot.intake.setRear(-0.8);
    Robot.intake.setOpen();
  }




  @Override
  protected boolean isFinished() {
    if (Robot.io.getEndIntake()){
      return true;
    }
    return false;

  }
  @Override
  protected void end() {
    super.end();
    Robot.intake.setFront(0);
    Robot.intake.setRear(0);
  }
}
