package com.team2915.SER_CHUNKY.commands.elevator;

import com.team2915.SER_CHUNKY.Robot;
import com.team2915.SER_CHUNKY.RobotMap.Elevator.Constants;
import edu.wpi.first.wpilibj.command.Command;

public class DriveMotionMagic extends Command {

  public DriveMotionMagic() {
    requires(Robot.elevator);
  }

  @Override
  protected void execute() {
    super.execute();
//    if (Robot.elevator.isDown()) {
//      Robot.elevator.zeroEncoders();
//    }
//    if (Robot.elevator.isUp() || Robot.elevator.isDown()) {
//      Robot.elevator.setSpeed(0);
//    } else {
//      if (Robot.io.getElevatorSetpointScaleHigh()) {
//        Robot.elevator.setMotionMagicSetpoint(Constants.SCALE_HIGH);
//      } else if (Robot.io.getElevatorSetpointScaleLow()) {
//        Robot.elevator.setMotionMagicSetpoint(Constants.SCALE_LOW);
//      } else if (Robot.io.getElevatorSetpointScaleBalanced()) {
//        Robot.elevator.setMotionMagicSetpoint(Constants.SCALE_BALANCED);
//      } else if (Robot.io.getElevatorSetpointSwitch()) {
//        Robot.elevator.setMotionMagicSetpoint(Constants.SWITCH);
//      } else if (Robot.io.getElevatorSetpointFloor()) {
//        Robot.elevator.setMotionMagicSetpoint(Constants.FLOOR);
//      }
//    }


  }

  @Override
  protected boolean isFinished() {
    return true;
  }
}
