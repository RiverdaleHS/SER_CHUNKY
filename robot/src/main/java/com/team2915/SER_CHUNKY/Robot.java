package com.team2915.SER_CHUNKY;


import com.team2915.SER_CHUNKY.subsystems.Chassis;
import com.team2915.SER_CHUNKY.subsystems.Climber;
import com.team2915.SER_CHUNKY.subsystems.Elevator;
import com.team2915.SER_CHUNKY.subsystems.Intake;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * Created by Henry on 5/2/17.
 */
public class Robot extends IterativeRobot {

    Chassis chassis = new Chassis();
    Climber climber = new Climber();
    Elevator elevator = new Elevator();
    Intake intake = new Intake();

    @Override
    public void robotInit() {
        super.robotInit();

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

    }

    @Override
    public void autonomousPeriodic() {
        super.autonomousPeriodic();


    }
}
