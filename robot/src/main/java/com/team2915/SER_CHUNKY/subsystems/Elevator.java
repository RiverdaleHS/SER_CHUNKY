package com.team2915.SER_CHUNKY.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.team2915.SER_CHUNKY.RobotMap.Elevator.Motors;
import com.team2915.SER_CHUNKY.RobotMap.Elevator.Sensors;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

  private DigitalInput topA = new DigitalInput(Sensors.LIMIT_TOP_A);
  private DigitalInput topB = new DigitalInput(Sensors.LIMIT_TOP_B);
  private DigitalInput bottomA = new DigitalInput(Sensors.LIMIT_BOTTOM_A);
  private DigitalInput bottomB = new DigitalInput(Sensors.LIMIT_BOTTOM_B);

  private TalonSRX left = new TalonSRX(Motors.LEFT);
  private TalonSRX right = new TalonSRX(Motors.RIGHT);

  public Elevator() {
    right.setInverted(true);
    right.set(ControlMode.Follower, left.getDeviceID());

    left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    left.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 10);
    left.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);
    left.configNominalOutputForward(0, 10);
    left.configNominalOutputReverse(0, 10);
    left.configPeakOutputForward(1, 10);
    left.configPeakOutputReverse(-1, 10);
    configuePIDF();

  }

  @Override
  protected void initDefaultCommand() {

  }


  public boolean isUp() {
    if (topA.get() | topB.get()) {
      return true;
    }
    return false;
  }

  public boolean isDown() {
    if (bottomA.get() | bottomB.get()) {
      return true;
    }
    return false;
  }


  public void configuePIDF() {
    //TODO: connect to smart dashboard
    left.selectProfileSlot(0, 0);
    left.config_kP(0, 0, 10);
    left.config_kI(0, 0, 10);
    left.config_kD(0, 0, 10);
    left.config_kF(0, 0, 10);
    left.configMotionCruiseVelocity(100, 10);
    left.configMotionAcceleration(100, 10);

  }

  public void setSpeed(double speed) {
    left.set(ControlMode.PercentOutput, speed);
  }

  public void setMotionMagicSetpoint(double setpoint) {
    left.set(ControlMode.MotionMagic, setpoint);
  }
}
