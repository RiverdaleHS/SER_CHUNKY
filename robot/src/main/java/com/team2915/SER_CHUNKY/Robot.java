package com.team2915.SER_CHUNKY;

import com.team2915.SER_CHUNKY.autoroutines.DriveToAutoLine;
import com.team2915.SER_CHUNKY.autoroutines.SmartAuto;
import com.team2915.SER_CHUNKY.autoroutines.SmartAuto.AutoType;
import com.team2915.SER_CHUNKY.autoroutines.SmartAuto.FieldPosition;
import com.team2915.SER_CHUNKY.commands.chassis.DriveChassisTimeBassed;
import com.team2915.SER_CHUNKY.subsystems.Chassis;
import com.team2915.SER_CHUNKY.subsystems.Elevator;
import com.team2915.SER_CHUNKY.subsystems.Intake;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by Henry on 5/2/17.
 */
public class Robot extends IterativeRobot {



  public static Chassis chassis = new Chassis();
  public static Elevator elevator = new Elevator();
  public static Intake intake = new Intake();
  //PowerDistributionPanel pdp = new PowerDistributionPanel();



  public static IO io = new IO();

  SendableChooser positionChooser = new SendableChooser();
  SendableChooser autoChooser = new SendableChooser();
  SendableChooser trajectoryAutoChooser = new SendableChooser();
  CommandGroup autoCommand;

  UsbCamera cam0;
  CvSink cvsink0;
  VideoSink server;

  @Override
  public void robotInit() {
    super.robotInit();
    //Add our subsystems to SmartDashboard so that we can see what commands are running on them
    SmartDashboard.putData(chassis);

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
    SmartDashboard.putData("Position", positionChooser);


    autoChooser.addDefault("Line Cross", AutoType.LINE_CROSS);
    autoChooser.addObject("Do Nothing", AutoType.DO_NOTHING);
    autoChooser.addObject("Place One", AutoType.PLACE_ONE);
    SmartDashboard.putData("Auto", autoChooser);

    trajectoryAutoChooser.addDefault("Profiled", true);
    trajectoryAutoChooser.addObject("TimeBased", false);
    SmartDashboard.putData("Traj", trajectoryAutoChooser);

    SmartDashboard.putNumber("Auto Delay", 0);

  }

  @Override
  public void disabledPeriodic() {
    super.disabledPeriodic();
    updateSD();

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
    updateSD();
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

    autoCommand = new SmartAuto(robotPosition, switchPosition, scalePosition, autoType, SmartDashboard.getNumber("Auto Delay", 0), (boolean) trajectoryAutoChooser.getSelected());
    Scheduler.getInstance().add(autoCommand);
    //Scheduler.getInstance().add(new DriveChassisTimeBassed(0.5, 2000));

  }

  @Override
  public void autonomousPeriodic() {
    super.autonomousPeriodic();
    Scheduler.getInstance().run(); //TODO: is this really needed?
    updateSD();
  }

  private void updateSD(){
    SmartDashboard.putNumber("Left Encoder", chassis.getLeftEncoder());
    SmartDashboard.putNumber("Right Encoder", chassis.getRightEncoder());
//    SmartDashboard.putNumber("Right Master", pdp.getCurrent(0));
//    SmartDashboard.putNumber("Right SlaveA", pdp.getCurrent(2));
//    SmartDashboard.putNumber("Right SlaveB", pdp.getCurrent(1));
//    SmartDashboard.putNumber("Left Master", pdp.getCurrent(15));
//    SmartDashboard.putNumber("Left SlaveA", pdp.getCurrent(13));
//    SmartDashboard.putNumber("Left SlaveB", pdp.getCurrent(14));
//    SmartDashboard.putNumber("Elevator Left", pdp.getCurrent(8));//Left
//    SmartDashboard.putNumber("Elevator Right", pdp.getCurrent(9));
//    SmartDashboard.putNumber("Intake Left Rear", pdp.getCurrent(7));
//    SmartDashboard.putNumber("Intake Right Rear", pdp.getCurrent(6));
//    SmartDashboard.putNumber("Intake Front A", pdp.getCurrent(10));
//    SmartDashboard.putNumber("Intake Front B", pdp.getCurrent(11));
  }
}
