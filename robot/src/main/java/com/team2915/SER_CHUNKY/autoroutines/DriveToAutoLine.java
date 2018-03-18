package com.team2915.SER_CHUNKY.autoroutines;

import com.team2915.SER_CHUNKY.commands.chassis.DriveChassisTimeBassed;
import com.team2915.SER_CHUNKY.commands.chassis.ExecuteStraightTrajectory;
import com.team2915.SER_CHUNKY.util.motion.TrajectoryUtils;
import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Waypoint;

public class DriveToAutoLine extends CommandGroup {
  public DriveToAutoLine(){
    addSequential(new DriveChassisTimeBassed(0.3, 1000));
//    //I think degrees are in radians
//
//    //10 feet = 3.048m
//    //go 3.1 so be safe
//    Waypoint[] waypoints = new Waypoint[]{
//        new Waypoint(0, 0, 0),
//        new Waypoint(2.12, 0, 0)
//    };
//    addSequential(new ExecuteStraightTrajectory(TrajectoryUtils.generateTrajectory(waypoints)));
  }

}

