package com.team2915.SER_CHUNKY;

import com.team2915.SER_CHUNKY.subsystems.Chassis;
import com.team2915.SER_CHUNKY.subsystems.Climber;
import com.team2915.SER_CHUNKY.subsystems.Elevator;
import com.team2915.SER_CHUNKY.subsystems.Intake;
import com.team2915.SER_CHUNKY.util.Logger;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by Henry on 5/2/17.
 */
public class Robot extends IterativeRobot {

  public static Chassis chassis = new Chassis();
  public static Climber climber = new Climber();
  public static Elevator elevator = new Elevator();
  public static Intake intake = new Intake();


  @Override
  public void robotInit() {
    super.robotInit();
    //Add our subsystems to SmartDashboard so that we can see what commands are running on them
    SmartDashboard.putData(chassis);
    SmartDashboard.putData(climber);
    SmartDashboard.putData(elevator);
    SmartDashboard.putData(intake);


  }

  @Override
  public void disabledPeriodic() {
    super.disabledPeriodic();


  }

  @Override
  public void teleopInit() {
    super.teleopInit();

  }

  @Override
  public void teleopPeriodic() {
    super.teleopPeriodic();


  }

  @Override
  public void autonomousInit() {
    super.autonomousInit();
    Alliance alliance = DriverStation.getInstance().getAlliance();
    int allianceStation = (int) SmartDashboard.getNumber("Alliance Station", -1);
    String gamePattern = DriverStation.getInstance().getGameSpecificMessage();
    try {
      if (gamePattern.charAt(0) == 'l') {

      }
    } catch (Exception e) {
      Logger.logTXT("auto", "Could not read game pattern at index 0, " + e.getMessage());
    }

  }

  @Override
  public void autonomousPeriodic() {
    super.autonomousPeriodic();


  }
}
