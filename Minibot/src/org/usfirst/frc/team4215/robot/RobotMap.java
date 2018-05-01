package org.usfirst.frc.team4215.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public final static int victorWheel_backright = 1;
	public final static int victorWheel_frontright = 0;
	public final static int victorWheel_backleft = 3;
	public final static int victorWheel_frontleft = 2;
	public final static int driveStick = 0; 
	public final static int numberOfWheels = 4;

	public final static int talonWheel_backright = 2;
	public final static int talonWheel_frontright = 3;
	public final static int talonWheel_backleft = 1;
	public final static int talonWheel_frontleft = 0;
	
	public final static int OmniInt = 2;
	public final static int TankInt = 0;
	public final static int MecanumInt = 1;

	public final static int adjutantJoystick = 1;
	
	public final static double wheelCircumference = 18.875; // Essentially 6*pi, however the C is a little larger in reality

}
