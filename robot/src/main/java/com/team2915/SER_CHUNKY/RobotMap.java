package com.team2915.SER_CHUNKY;


import edu.wpi.first.wpilibj.SPI;

public class RobotMap {

    public static class Chassis{
        public static class Sensors{
            public static final SPI.Port AHRS_PORT = SPI.Port.kMXP;
            public static final int LEFT_ENCODER_A = 0;
            public static final int LEFT_ENCODER_B = 1;
            public static final int RIGHT_ENCODER_A = 2;
            public static final int RIGHT_ENCODER_B = 3;
        }
        public static class Motors{
            public static final int LEFT_MASTER = 30;
            public static final int LEFT_SLAVEA = 31;
            public static final int LEFT_SLAVEB = 32;
            public static final int RIGHT_MASTER = 20;
            public static final int RIGHT_SLAVEA = 21;
            public static final int RIGHT_SLAVEB = 22;
        }
        public static class Solenoids{
            public static final int SHIFTER_A = 2;
            public static final int SHIFTER_B = 1;
        }
    }

    public static class Elevator{
        public static class Sensors{
            public static final int LIMIT_TOP_A = 3;
            public static final int LIMIT_TOP_B = 4;
            public static final int LIMIT_BOTTOM_A = 5;
            public static final int LIMIT_BOTTOM_B = 6;

        }
        public static class Motors{
            public static final int LEFT = 6;
            public static final int RIGHT = 7;
        }
    }

    public static class Intake{
        public static class Sensors{
            public static final int CUBE_IN = 4;
            public static final int CUBE_OUT = 5;
        }
        public static class Motors{
            public static final int LEFT_REAR = 0;
            public static final int RIGHT_REAR = 1;
            public static final int LEFT_FRONT = 1;
            public static final int RIGHT_FRONT = 2;
        }
        public static class Solenoids{
            public static final int SHIFTER_A = 0;
            public static final int SHIFTER_A = 3;
        }
    }

    public static class Climber{
        public static class Motors{
            public static final int CLIMBER = 0;
        }
    }
}