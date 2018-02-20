package com.team2915.SER_CHUNKY.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.team2915.SER_CHUNKY.RobotMap;
import com.team2915.SER_CHUNKY.RobotMap.Intake.Solenoids;
import com.team2915.SER_CHUNKY.commands.intake.HoldCube;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

  private Ultrasonic cubeUltrasonic = new Ultrasonic(RobotMap.Intake.Sensors.CUBE_IN,
      RobotMap.Intake.Sensors.CUBE_OUT);//should be correct

  DoubleSolenoid frontClamp = new DoubleSolenoid(Solenoids.SHIFTER_A, Solenoids.SHIFTER_B);

  private TalonSRX leftRear = new TalonSRX(RobotMap.Intake.Motors.LEFT_REAR);
  private TalonSRX rightRear = new TalonSRX(RobotMap.Intake.Motors.RIGHT_REAR);
  private Spark leftFront = new Spark(RobotMap.Intake.Motors.LEFT_FRONT);
  private Spark rightFront = new Spark(RobotMap.Intake.Motors.RIGHT_FRONT);


  public Intake() {
    //INVERT RIGHT
    rightRear.setInverted(false);
    rightFront.setInverted(false);
    leftRear.setInverted(true);
    leftFront.setInverted(true);
    cubeUltrasonic.setAutomaticMode(true);//TODO: learn more about this
  }


  protected void initDefaultCommand() {
    setDefaultCommand(new HoldCube());
  }

  public double getCubeDistanceInches() {
    return cubeUltrasonic.getRangeInches();
  }


  public void setOpen() {
    frontClamp.set(Value.kForward);
  }

  public void setClosed() {
    frontClamp.set(Value.kReverse);
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
