package org.usfirst.frc.team4215.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drivetrain code
 * 
 * A majority of Credit goes to Waweru Kariuki and James Yu, from the 2016 Stronghold code.
 * 
 */
public class Drivetrain extends Subsystem {
	
	Victor leftMotor;
    Victor rightMotor;
    Victor rightMotor2;
    Victor leftMotor2;
    
    /**
     * Set Drive train speed Inputs from -1 to 1
     *
     * @param leftSpeed
     * @param rightSpeed
     */
    public void drive(double leftSpeed, double rightSpeed) {
        /*
         * The Victors don't respond to a voltage of less then 4%
         * either direction so I provided some scaling.
         */
        /*
         * The scaling part is moved into a new function to simplify
         * the code. - James
         */
        leftSpeed = scaling(leftSpeed);
        rightSpeed = scaling(rightSpeed);
        
        leftMotor.set(-leftSpeed);
        leftMotor2.set(-leftSpeed);
        rightMotor.set(rightSpeed);
        rightMotor2.set(rightSpeed);
    }
    
    /**
     * Scaling because Victor does not response to volts less than 4%
     * either direction.
     *
     * @param speed
     * @return scaled speed
     */
    private static double scaling(double speed) {
        if (speed == 0) return 0d;
        else return Math.signum(speed)
                * ((Math.abs(speed) * .96) + .04);
    }
    
    /**
     * You can use this function when left speed and right speed are
     * the same.
     *
     * @author James
     * @param speed
     */
    public void drive(double speed) {
        drive(speed, speed);
    }
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

