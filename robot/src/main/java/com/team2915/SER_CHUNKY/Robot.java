package com.team2915.SER_CHUNKY;

import com.team2915.SER_CHUNKY.autoroutines.SmartAuto;
import com.team2915.SER_CHUNKY.autoroutines.SmartAuto.AutoType;
import com.team2915.SER_CHUNKY.autoroutines.SmartAuto.FieldPosition;
import com.team2915.SER_CHUNKY.subsystems.Chassis;
import com.team2915.SER_CHUNKY.subsystems.Climber;
import com.team2915.SER_CHUNKY.subsystems.Elevator;
import com.team2915.SER_CHUNKY.subsystems.Intake;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
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



  public static Chassis chassis = new Chassis();
  public static Climber climber = new Climber();
  public static Elevator elevator = new Elevator();
  public static Intake intake = new Intake();

  public static IO io = new IO();

  SendableChooser positionChooser = new SendableChooser();
  SendableChooser autoChooser = new SendableChooser();
  CommandGroup autoCommand;

  UsbCamera cam0;
  CvSink cvsink0;
  VideoSink server;

  @Override
  public void robotInit() {
    super.robotInit();
    //Add our subsystems to SmartDashboard so that we can see what commands are running on them
    SmartDashboard.putData(chassis);
    SmartDashboard.putData(climber);
    SmartDashboard.putData(elevator);
    SmartDashboard.putData(intake);


    cam0 = CameraServer.getInstance().startAutomaticCapture(0);
    cam0.setResolution(320, 240);
    cam0.setExposureAuto();
    cam0.setWhiteBalanceAuto();
    server = CameraServer.getInstance().getServer();
    cvsink0 = new CvSink("cam0cv");

    cvsink0.setSource(cam0);
    cvsink0.setEnabled(true);
    //Add auto chooser

    positionChooser.addDefault("Left SC", FieldPosition.LEFT_SCALE);
    positionChooser.addObject("Left SW", FieldPosition.LEFT_SWITCH);
    positionChooser.addObject("Center SW", FieldPosition.CENTER_SWITCH);
    positionChooser.addObject("Right SC", FieldPosition.RIGHT_SWITCH);
    positionChooser.addObject("Right SC", FieldPosition.RIGHT_SCALE);



    autoChooser.addDefault("Line Cross", AutoType.LINE_CROSS);
    autoChooser.addObject("Do Nothing", AutoType.DO_NOTHING);
    SmartDashboard.putData("Auto", autoChooser);
    SmartDashboard.putData("Position", positionChooser);

    SmartDashboard.putNumber("Auto Delay", 0);

  }

  @Override
  public void disabledPeriodic() {
    super.disabledPeriodic();


  }

  @Override
  public void teleopInit() {
    super.teleopInit();
    if (autoCommand != null){
      autoCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    super.teleopPeriodic();
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("Cube Ultrasonic", intake.getCubeDistanceInches());
  }

  @Override
  public void autonomousInit() {
    super.autonomousInit();
    String gameSpecificMessage = DriverStation.getInstance().getGameSpecificMessage();

    FieldPosition robotPosition = (FieldPosition) positionChooser.getSelected();
    AutoType autoType = (AutoType) autoChooser.getSelected();
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

    autoCommand = new SmartAuto(robotPosition, switchPosition, scalePosition, autoType, SmartDashboard.getNumber("Auto Delay", 0));
    Scheduler.getInstance().add(autoCommand);

  }

  @Override
  public void autonomousPeriodic() {
    super.autonomousPeriodic();
    Scheduler.getInstance().run(); //TODO: is this really needed?

  }
}
