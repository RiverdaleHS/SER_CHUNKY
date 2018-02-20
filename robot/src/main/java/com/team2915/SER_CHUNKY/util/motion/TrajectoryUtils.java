package com.team2915.SER_CHUNKY.util.motion;

import com.team2915.SER_CHUNKY.RobotMap.Chassis.Constants;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

public class TrajectoryUtils {

  public static Trajectory generateTrajectory(Waypoint[] waypoints) {
    Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
        Trajectory.Config.SAMPLES_HIGH, 0.05,
        Constants.MAX_PATH_VELOCITY, Constants.MAX_PATH_ACCELERATION, Constants.MAX_PATH_JERK);
    Trajectory trajectory = Pathfinder.generate(waypoints, config);
    return trajectory;
  }

}
