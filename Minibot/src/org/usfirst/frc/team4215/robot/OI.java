package org.usfirst.frc.team4215.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystick;
	public AnalogGyro gyro;
	public JoystickButton sampleButton;
	public JoystickButton intakeButton;
	
	public double getMagnitude() {  
		return joystick.getMagnitude(); 
		}
	public double getTheta() { 
		return joystick.getDirectionRadians(); 
		}
	public double getRotation() {
		return joystick.getTwist(); 
		}
	public double getSlider() {
		double SliderVal = (joystick.getRawAxis(3)+1)/2;
		return SliderVal;
	}
	
	public OI() {
		super();
		//instantiates joystick and intake button
		this.joystick = new Joystick(RobotMap.driveStick);
	}
}
