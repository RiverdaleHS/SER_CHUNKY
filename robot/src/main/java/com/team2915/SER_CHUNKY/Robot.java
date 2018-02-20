package com.team2915.SER_CHUNKY;

import com.team2915.SER_CHUNKY.autoroutines.SmartAuto;
import com.team2915.SER_CHUNKY.autoroutines.SmartAuto.FieldPosition;
import com.team2915.SER_CHUNKY.subsystems.Chassis;
import com.team2915.SER_CHUNKY.subsystems.Climber;
import com.team2915.SER_CHUNKY.subsystems.Elevator;
import com.team2915.SER_CHUNKY.subsystems.Intake;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by Henry on 5/2/17.
 */
public class Robot extends IterativeRobot {

  public static IO io = new IO();

  public static Chassis chassis = new Chassis();
  public static Climber climber = new Climber();
  public static Elevator elevator = new Elevator();
  public static Intake intake = new Intake();

  SendableChooser positionChooser = new SendableChooser();
  CommandGroup autoCommand;

  @Override
  public void robotInit() {
    super.robotInit();
    //Add our subsystems to SmartDashboard so that we can see what commands are running on them
    SmartDashboard.putData(chassis);
    SmartDashboard.putData(climber);
    SmartDashboard.putData(elevator);
    SmartDashboard.putData(intake);

    //Add auto chooser
    positionChooser.addDefault("Do Nothing", FieldPosition.DO_NOTHING);
    positionChooser.addDefault("Left Scale", FieldPosition.LEFT_SCALE);
    positionChooser.addDefault("Left Switch", FieldPosition.LEFT_SWITCH);
    positionChooser.addDefault("Center Switch", FieldPosition.CENTER_SWITCH);
    positionChooser.addDefault("Right Switch", FieldPosition.RIGHT_SWITCH);
    positionChooser.addDefault("Right Scale", FieldPosition.RIGHT_SCALE);
    positionChooser.addDefault("Line Cross", FieldPosition.LINE_CROSS);
    SmartDashboard.putData(positionChooser);
    SmartDashboard.putNumber("Auto Delay", 0);

  }

  @Override
  public void disabledPeriodic() {
    super.disabledPeriodic();


  }

  @Override
  public void teleopInit() {
    super.teleopInit();
    autoCommand.cancel();
  }

  @Override
  public void teleopPeriodic() {
    super.teleopPeriodic();
    Scheduler.getInstance().run();

  }

  @Override
  public void autonomousInit() {
    super.autonomousInit();
    String gameSpecificMessage = DriverStation.getInstance().getGameSpecificMessage();

    FieldPosition robotPosition = (FieldPosition) positionChooser.getSelected();
    FieldPosition switchPosition;
    if (gameSpecificMessage.charAt(0) == 'L') {
      switchPosition = FieldPosition.LEFT_SWITCH;
    } else {
      switchPosition = FieldPosition.RIGHT_SWITCH;
    }

    FieldPosition scalePosition;
    if (gameSpecificMessage.charAt(1) == 'L') {
      scalePosition = FieldPosition.LEFT_SCALE;
    } else {
      scalePosition = FieldPosition.RIGHT_SCALE;
    }

    autoCommand = new SmartAuto(robotPosition, switchPosition, scalePosition, SmartDashboard.getNumber("Auto Delay", 0));
    Scheduler.getInstance().add(autoCommand);

  }

  @Override
  public void autonomousPeriodic() {
    super.autonomousPeriodic();
    Scheduler.getInstance().run(); //TODO: is this really needed?

  }
}
