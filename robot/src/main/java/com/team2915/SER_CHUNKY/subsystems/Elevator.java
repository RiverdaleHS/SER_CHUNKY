package com.team2915.SER_CHUNKY.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.team2915.SER_CHUNKY.RobotMap.Elevator.Motors;
import com.team2915.SER_CHUNKY.RobotMap.Elevator.Sensors;
import com.team2915.SER_CHUNKY.commands.elevator.DriveManual;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

  private DigitalInput topA = new DigitalInput(Sensors.LIMIT_TOP);
  private DigitalInput bottomA = new DigitalInput(Sensors.LIMIT_BOTTOM);

  private TalonSRX left = new TalonSRX(Motors.LEFT);
  private TalonSRX right = new TalonSRX(Motors.RIGHT);

  public Elevator() {
    left.setNeutralMode(NeutralMode.Brake);
    right.setNeutralMode(NeutralMode.Brake);
    right.setInverted(true);
    right.set(ControlMode.Follower, left.getDeviceID());

//    left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
//    left.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 10);
//    left.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);
//    left.configNominalOutputForward(0, 10);
//    left.configNominalOutputReverse(0, 10);
//    left.configPeakOutputForward(1, 10);
//    left.configPeakOutputReverse(-1, 10);
//    configuePIDF();

  }

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new DriveManual());
  }


  public boolean isUp() {
    if (topA.get()) {
      return true;
    }
    return false;
  }

  public boolean isDown() {
    if (bottomA.get()) {
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

  public void zeroEncoders() {
    left.setSelectedSensorPosition(0, 0, 10);
  }

  public void setSpeed(double speed) {
//    if (isUp() && speed > 0) {
//      left.set(ControlMode.PercentOutput, 0);
//    } else if (isDown() && speed < 0) {
//      left.set(ControlMode.PercentOutput, 0);
//    } else {
//      left.set(ControlMode.PercentOutput, speed);
//    }
//    if (isUp() && speed > 0) {
//      left.set(ControlMode.PercentOutput, 0);
//    } else {
//
//    }
    left.set(ControlMode.PercentOutput, speed);
  }

  public void setMotionMagicSetpoint(double setpoint) {
    left.set(ControlMode.MotionMagic, setpoint);
  }

}
