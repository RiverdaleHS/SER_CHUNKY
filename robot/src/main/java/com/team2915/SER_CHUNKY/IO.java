package com.team2915.SER_CHUNKY;

import edu.wpi.first.wpilibj.Joystick;

public class IO {

  private Joystick pilot = new Joystick(0);
  private Joystick copilot = new Joystick(1);

  //Chassis
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

  //Elevator
  public double getElevatorThrottle() {
    return copilot.getRawAxis(0);//TODO: Test
  }

  public boolean getELevatorSetpointScaleHigh() {
    return copilot.getRawButton(1);
  }

  public boolean getELevatorSetpointScaleBallanced() {
    return copilot.getRawButton(1);
  }

  public boolean getELevatorSetpointScaleLow() {
    return copilot.getRawButton(1);
  }

  public boolean getELevatorSetpointSwitch() {
    return copilot.getRawButton(1);
  }

  public boolean getELevatorSetpointFloor() {
    return copilot.getRawButton(1);
  }


  //Climber
  public boolean getClimb() {
    return copilot.getRawButton(0);//TODO: Test
  }

}
