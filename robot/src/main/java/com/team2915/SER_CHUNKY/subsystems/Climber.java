package com.team2915.SER_CHUNKY.subsystems;

import com.team2915.SER_CHUNKY.RobotMap.Climber.Motors;
import com.team2915.SER_CHUNKY.commands.climber.Climb;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

  private Spark climber = new Spark(Motors.CLIMBER);

  public void setClimber(double speed){
    climber.set(speed);
  }

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new Climb());
  }
}
