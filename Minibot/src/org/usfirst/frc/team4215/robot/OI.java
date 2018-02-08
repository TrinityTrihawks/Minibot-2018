package org.usfirst.frc.team4215.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;

import java.util.ArrayList;


/**
 * Most of this code is also from 2016
 * In an effort to do as little work as possible, I am attempting to port over as much code as possible from previous years.
 * As a result, much of it is clunky and unneeded at this point
 * 
 * Authors: Waweru Kariuki and James Yu
 * Assembled by Ransom Schmidt
 * 
 */
public class OI {

	
	ArrayList<Joystick> driveSticks = new  ArrayList<Joystick>();
    Joystick thirdstick;
    
    public Joystick leftStick, rightStick;
    public String dashStr1, dashStr2, dashStr3, dashStr4, dashStr5;
    public Victor frontLeftMotor, backLeftMotor, backRightMotor,
            frontRightMotor, intake, arm;
    
	public void UI(Joystick leftStick_, Joystick rightStick_,
            Joystick thirdstick_, Victor leftmotor_,
            Victor rightmotor_, Victor rightmotor2_,
            Victor leftmotor2_, Victor intake_, Victor arm_) {
        driveSticks.add(leftStick_);
        driveSticks.add(rightStick_);
        this.thirdstick = thirdstick_;
        this.frontLeftMotor = leftmotor_;
        this.frontRightMotor = rightmotor_;
        this.backLeftMotor = leftmotor2_;
        this.backRightMotor = rightmotor2_;
    }
	
	public void UI(Joystick leftStick_,
            Joystick thirdstick_, Victor leftmotor_,
            Victor rightmotor_, Victor rightmotor2_,
            Victor leftmotor2_, Victor intake_, Victor arm_) {
        driveSticks.add(leftStick_);
        this.thirdstick = thirdstick_;
        this.frontLeftMotor = leftmotor_;
        this.frontRightMotor = rightmotor_;
        this.backLeftMotor = leftmotor2_;
        this.backRightMotor = rightmotor2_;
    }
	
	double[] getDriveInputs() {
        double[] inputs = new double[2];
        if (this.driveSticks.size() == 1) {
            inputs[0] = this.driveSticks.get(0).getRawAxis(1);
            inputs[1] = this.driveSticks.get(0).getRawAxis(5);
        } else {
            inputs[0] = this.driveSticks.get(0).getRawAxis(1);
            inputs[1] = this.driveSticks.get(1).getRawAxis(1);
        }
        return inputs;
    }
}
