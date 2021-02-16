// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class OPSCONTROL{
        public static final int OPSControl = 0; //Logitech Controller Pad
        //Controller Axes
        public static final int LEFT_Y_AXIS = 1; 
        public static final int LEFT_X_AXIS = 0; 
        public static final int RIGHT_Y_AXIS = 5; 
        public static final int RIGHT_X_AXIS = 4; 
        public static final int LEFT_TRIGGER = 2; 
        public static final int RIGHT_TRIGGER = 3;
        //Controller Buttons
        public static final int A_BUTTON = 1; 
        public static final int B_BUTTON = 2; 
        public static final int X_BUTTON = 3;
        public static final int Y_BUTTON = 4;
        public static final int LT_BUMPER = 5;
        public static final int RT_BUMPER = 6; 
    }
    public final class DriverJoystick{
        public static final int DriverStick = 1; //Logitech Controller Pad
        //Controller Axes
        public static final int LEFT_Y_AXIS = 1; 
        public static final int LEFT_X_AXIS = 0; 
        public static final int RIGHT_Y_AXIS = 5; 
        public static final int RIGHT_X_AXIS = 4; 
        public static final int LEFT_TRIGGER = 2; 
        public static final int RIGHT_TRIGGER = 3;
        //Controller Buttons
        public static final int A_BUTTON = 1; 
        public static final int B_BUTTON = 2; 
        public static final int X_BUTTON = 3;
        public static final int Y_BUTTON = 4;
        public static final int LT_BUMPER = 5;
        public static final int RT_BUMPER = 6; 
    }

    public static final class PneumaticConstants{

        public static final int IntakeSolenoidModule = 0;
		public static final int[] IntakeSolenoidPorts = new int[] { 0, 1 };
        

    }
    public final class MotorControllers{
        public static final int LEFT_FRONT = 3;//Talon FX
        public static final int LEFT_REAR = 4;//Talon FX
        public static final int RIGHT_FRONT = 5;//Talon FX
        public static final int RIGHT_REAR = 6;//Talon FX
		public static final int LEFTSHOOTER = 5;//CANSParkMax
        public static final int RIGHTSHOOTER = 1;//CANSParkMax
		public static final int INTAKE = 4;
		public static final int TURRET = 7;
        public static final int ELEVATOR_1 = 9;
	    public static final int ELEVATOR_2 = 10;
        public static final int HOPPER = 8;
    }
    public final class AutoConstants{
        public static final double DRIVETIME = 4.5;
        public static final double AUTOSPEED = .4;
        public static final double INTAKEDELAY = .75;
    }
    public final class MotorSpeeds{
        public static final double DRIVESPEED = .6;
		public static final double SHOOTERSPEED = 1.0;
		public static final double INTAKESPEED = .8;
		public static final double TURRETSPEED = -.4;
        public static final double ELEVATOR_SPEED = .6;
	    public static final double HOPPER_SPEED = .7;
    }
}
	
	

