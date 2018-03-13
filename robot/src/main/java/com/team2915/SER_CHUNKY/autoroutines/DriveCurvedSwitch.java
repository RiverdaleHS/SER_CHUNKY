package com.team2915.SER_CHUNKY.autoroutines;

import com.team2915.SER_CHUNKY.autoroutines.SmartAuto.FieldPosition;
import com.team2915.SER_CHUNKY.commands.chassis.ExecuteCruvedTrajectory;
import com.team2915.SER_CHUNKY.util.motion.TrajectoryUtils;
import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class DriveCurvedSwitch extends CommandGroup {

  public DriveCurvedSwitch(FieldPosition switchPosition) {
    Waypoint[] left = new Waypoint[]{
        new Waypoint(0, 0, 0),
        new Waypoint(1.7, -0.6, Pathfinder.d2r(-40)),
        new Waypoint(3.556, -1.2192, 0)
    };
    Waypoint[] right = new Waypoint[]{
        new Waypoint(0, 0, 0),
        new Waypoint(1.7, 0.6, Pathfinder.d2r(40)),
        new Waypoint(3.556, 1.2192, 0)
    };
    if (switchPosition == FieldPosition.LEFT_SWITCH) {
      addSequential(new ExecuteCruvedTrajectory(TrajectoryUtils.generateTrajectory(left)));
    }
    if (switchPosition == FieldPosition.RIGHT_SWITCH) {
      addSequential(new ExecuteCruvedTrajectory(TrajectoryUtils.generateTrajectory(left)));
    }
  }

}
