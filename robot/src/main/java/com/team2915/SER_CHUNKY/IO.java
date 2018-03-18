package com.team2915.SER_CHUNKY;

import com.team2915.SER_CHUNKY.commands.chassis.DriveChassisTimeBassed;
import com.team2915.SER_CHUNKY.commands.elevator.DriveTimeBased;
import com.team2915.SER_CHUNKY.commands.intake.CollectCube;
import com.team2915.SER_CHUNKY.commands.intake.EjectCube;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class IO {

  private Joystick pilot = new Joystick(0);
  private Joystick copilot = new Joystick(1);

  private JoystickButton eject = new JoystickButton(copilot, 1);
  private JoystickButton collect = new JoystickButton(copilot, 2);

  private JoystickButton timeElevator = new JoystickButton(copilot, 5);



  public IO() {
    eject.whenPressed(new EjectCube());
    collect.whenPressed(new CollectCube());
    timeElevator.whenPressed(new DriveChassisTimeBassed(0.3, 1000));
  }

  //Chassis
  //Teleop
  public double getThrottle() {
    return pilot.getRawAxis(1);
  }

  public double getTurn() {
    return pilot.getRawAxis(4);
  }

  public boolean getQuickTurn() {
    return pilot.getRawButton(6);
  }

  public boolean getShiftLow() {
    return pilot.getRawButton(5);
  }

  public boolean getPinchCube() {
    return copilot.getRawButton(3);
  }
  //Characterize
//  public boolean getCharacterizeAddPower(){
//    return copilot.getRawButton(4);
//  }
//  public boolean getCharacterizeLowerPower(){
//    return copilot.getRawButton(5);
//  }
//  public boolean getCharacterizeLog(){
//    return copilot.getRawButton(6);
//  }

  //Elevator
  public double getElevatorThrottle() {
    return copilot.getRawAxis(1);//TODO: Test
  }

//  public boolean getElevatorSetpointScaleHigh() {
//    return copilot.getRawButton(1);
//  }
//
//  public boolean getElevatorSetpointScaleBalanced() {
//    return copilot.getRawButton(1);
//  }
//
//  public boolean getElevatorSetpointScaleLow() {
//    return copilot.getRawButton(1);
//  }
//
//  public boolean getElevatorSetpointSwitch() {
//    return copilot.getRawButton(1);
//  }
//
//  public boolean getElevatorSetpointFloor() {
//    return copilot.getRawButton(1);
//  }


  //Climber
  public boolean getEndIntake() {
    return copilot.getRawButton(7);
  }

}
