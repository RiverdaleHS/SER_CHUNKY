package com.team2915.SER_CHUNKY.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.team2915.SER_CHUNKY.RobotMap;
import com.team2915.SER_CHUNKY.RobotMap.Chassis.Solenoids;
import com.team2915.SER_CHUNKY.commands.chassis.DriveOpenLoop;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {

  private AHRS navx = new AHRS(RobotMap.Chassis.Sensors.AHRS_PORT);

  private DoubleSolenoid shifter = new DoubleSolenoid(Solenoids.SHIFTER_A, Solenoids.SHIFTER_B);

  private TalonSRX leftMaster = new TalonSRX(RobotMap.Chassis.Motors.LEFT_MASTER);
  private TalonSRX leftSlaveA = new TalonSRX(RobotMap.Chassis.Motors.LEFT_SLAVEA);
  private TalonSRX leftSlaveB = new TalonSRX(RobotMap.Chassis.Motors.LEFT_SLAVEB);

  private TalonSRX rightMaster = new TalonSRX(RobotMap.Chassis.Motors.RIGHT_MASTER);
  private TalonSRX rightSlaveA = new TalonSRX(RobotMap.Chassis.Motors.RIGHT_SLAVEA);
  private TalonSRX rightSlaveB = new TalonSRX(RobotMap.Chassis.Motors.RIGHT_SLAVEB);

  private Encoder leftEncoder = new Encoder(RobotMap.Chassis.Sensors.LEFT_ENCODER_A,
      RobotMap.Chassis.Sensors.LEFT_ENCODER_B);
  private Encoder rightEncoder = new Encoder(RobotMap.Chassis.Sensors.RIGHT_ENCODER_A,
      RobotMap.Chassis.Sensors.RIGHT_ENCODER_B);

  public Chassis() {
    rightMaster.setNeutralMode(NeutralMode.Brake);
    rightSlaveA.setNeutralMode(NeutralMode.Brake);
    rightSlaveB.setNeutralMode(NeutralMode.Brake);
    rightSlaveA.set(ControlMode.Follower, rightMaster.getDeviceID());
    rightSlaveB.set(ControlMode.Follower, rightMaster.getDeviceID());
    rightMaster.setInverted(false);
    rightSlaveA.setInverted(false);
    rightSlaveB.setInverted(false);

    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftSlaveA.setNeutralMode(NeutralMode.Brake);
    leftSlaveB.setNeutralMode(NeutralMode.Brake);
    leftSlaveA.set(ControlMode.Follower, leftMaster.getDeviceID());
    leftSlaveB.set(ControlMode.Follower, leftMaster.getDeviceID());
    leftMaster.setInverted(true);
    leftSlaveA.setInverted(true);
    leftSlaveB.setInverted(true);

    shiftLow();
    leftEncoder.reset();
    rightEncoder.reset();
    navx.reset();
  }

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new DriveOpenLoop());
  }

  public void shiftLow(){
    shifter.set(Value.kForward);
  }

  public void shiftHigh(){
    shifter.set(Value.kReverse);
  }

  public void setSpeed(double left, double right) {
    leftMaster.set(ControlMode.PercentOutput, left);
    rightMaster.set(ControlMode.PercentOutput, right);
  }

  public void stop() {
    leftMaster.set(ControlMode.PercentOutput, 0);
    rightMaster.set(ControlMode.PercentOutput, 0);
  }

  public int getLeftEncoder() {
    return leftEncoder.get();
  }

  public double getLeftEncoderRate() {
    return leftEncoder.getRate();
  }

  public double getRightEncoderRate() {
    return rightEncoder.getRate();
  }

  public int getRightEncoder() {
    return rightEncoder.get();
  }

  public double getAverageLeftVoltage() {
    return (leftMaster.getMotorOutputVoltage() + leftSlaveA.getMotorOutputVoltage()) / 3;
  }

  public double getAverageRightVoltage() {
    return (rightMaster.getMotorOutputVoltage() + rightSlaveA.getMotorOutputVoltage()) / 2;
  }

  public double getHeading() {
    return navx.pidGet();
  }

  public void zeroNavX() {
    navx.zeroYaw();
  }

  public float getAcceleration() {
    return navx.getRawAccelY();
    //TODO: This is in here for collision detection

  }
}