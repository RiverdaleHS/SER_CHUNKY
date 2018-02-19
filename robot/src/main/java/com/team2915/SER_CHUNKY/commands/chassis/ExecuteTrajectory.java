package com.team2915.SER_CHUNKY.commands.chassis;

import com.team2915.SER_CHUNKY.Robot;
import com.team2915.SER_CHUNKY.RobotMap.Chassis.Constants;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class ExecuteTrajectory extends Command {

  Trajectory trajectory;

  TankModifier tankModifier;
  EncoderFollower leftFollower;
  EncoderFollower rightFollower;
  Notifier notifier;

  Boolean hasRun = false;


  public ExecuteTrajectory(Trajectory traj) {
    requires(Robot.chassis);
    notifier = new Notifier(this::updateTracking);
    trajectory = traj;
  }


  @Override
  protected void execute() {
    super.execute();
    if (hasRun == false) {
      hasRun = true;
      tankModifier = new TankModifier(trajectory)
          .modify(Constants.TRACKWIDTH);
      leftFollower = new EncoderFollower(tankModifier.getLeftTrajectory());
      rightFollower = new EncoderFollower(tankModifier.getRightTrajectory());
      leftFollower.configurePIDVA(Constants.PROPORTIONAL, 0.0,
          Constants.DERIVATIVE,
          Constants.VELOCITY,
          Constants.ACCELERATION);
      rightFollower.configurePIDVA(Constants.PROPORTIONAL, 0.0,
          Constants.DERIVATIVE,
          Constants.VELOCITY,
          Constants.ACCELERATION);

      leftFollower.configureEncoder(Robot.chassis.getLeftEncoder(),
          Constants.TICKS_PER_REV,
          Constants.WHEEL_DIAMETER);
      rightFollower.configureEncoder(Robot.chassis.getLeftEncoder(),
          Constants.TICKS_PER_REV,
          Constants.WHEEL_DIAMETER);
      leftFollower.reset();
      rightFollower.reset();
      Robot.chassis.zeroNavX();
      notifier.startPeriodic(trajectory.get(0).dt);
    }

  }

  private void updateTracking() {
    double leftOutput = leftFollower.calculate(Robot.chassis.getLeftEncoder());
    double rightOutput = rightFollower.calculate(Robot.chassis.getRightEncoder());
    double desiredHeading = Pathfinder.r2d(leftFollower.getHeading());
    double angleDifference = Pathfinder
        .boundHalfDegrees(desiredHeading - Robot.chassis.getHeading());
    double turn = Constants.TURN_PROPORTIONAL
        * angleDifference; //This is a PD loop that modifies for turning.
    leftOutput = leftOutput - turn;
    rightOutput = rightOutput + turn;

    if (leftOutput > 0) {
      leftOutput = leftOutput + Constants.VELOCITY_INTERCEPT;
    }
    if (leftOutput < 0) {
      leftOutput = leftOutput - Constants.VELOCITY_INTERCEPT;
    }
    if (rightOutput > 0) {
      rightOutput = leftOutput + Constants.VELOCITY_INTERCEPT;
    }
    if (rightOutput < 0) {
      rightOutput = leftOutput - Constants.VELOCITY_INTERCEPT;
    }

    Robot.chassis.setSpeed(-leftOutput, -rightOutput);
  }

  @Override
  protected boolean isFinished() {
    if (leftFollower.isFinished() && rightFollower.isFinished()) {
      hasRun = false;
      notifier.stop();
      return true;
    }
    return false;
  }
}
