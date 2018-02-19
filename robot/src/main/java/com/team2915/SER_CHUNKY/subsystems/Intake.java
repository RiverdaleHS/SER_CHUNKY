package com.team2915.SER_CHUNKY.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.team2915.SER_CHUNKY.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

  private Ultrasonic cubeUltrasonic = new Ultrasonic(RobotMap.Intake.Sensors.CUBE_IN,
      RobotMap.Intake.Sensors.CUBE_OUT);

  private TalonSRX leftRear = new TalonSRX(RobotMap.Intake.Motors.LEFT_REAR);
  private TalonSRX rightRear = new TalonSRX(RobotMap.Intake.Motors.RIGHT_REAR);
  private Spark leftFront = new Spark(RobotMap.Intake.Motors.LEFT_FRONT);
  private Spark rightFront = new Spark(RobotMap.Intake.Motors.RIGHT_FRONT);


  public Intake() {

  }


  protected void initDefaultCommand() {
    setDefaultCommand();
  }

  public double getCubeDistanceInches() {
    return cubeUltrasonic.getRangeInches();
  }

  public void setLeftRear(double speed) {
    leftRear.set(ControlMode.PercentOutput, speed);
  }


  public void setRightRear(double speed) {
    rightRear.set(ControlMode.PercentOutput, speed);
  }


  public void setLeftFront(double speed) {
    leftFront.set(speed);
  }


  public void setRightFront(double speed) {
    rightFront.set(speed);
  }

  public void setFront(double speed) {
    leftFront.set(speed);
    rightFront.set(speed);
  }

  public void setRear(double speed) {
    leftRear.set(ControlMode.PercentOutput, speed);
    rightRear.set(ControlMode.PercentOutput, speed);
  }

}
