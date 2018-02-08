package org.usfirst.frc.team4215.robot.subsystems;

import org.usfirst.frc.team4215.robot.RobotMap;
import org.usfirst.frc.team4215.robot.commands.TeleopDrive;
import org.usfirst.frc.team4215.robot.subsystems.Drivetrain.wheelIndex;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drivetrain code:  
 * 
 * A majority of Credit goes to Waweru Kariuki and James Yu, from the 2016 Stronghold code.
 * 
 * Much of the code here is taken from the new 2018 model of code, and therefore is a little clunky but is designed for visibility
 */
public class Drivetrain extends Subsystem {
	
	public enum wheelIndex {
		backrightwheel(RobotMap.victorWheel_backright),
		frontrightwheel(RobotMap.victorWheel_frontright),
		backleftwheel(RobotMap.victorWheel_backleft),
		frontleftwheel(RobotMap.victorWheel_frontleft); 
		
		private int wheel;
		private wheelIndex (int value) {
			this.wheel = value;
		}
		public int getValue() {
			return wheel;
		}
	}
	

	/*
	Victor leftMotor;
    Victor rightMotor;
    Victor rightMotor2;
    Victor leftMotor2;
    */
	int numberWheels = RobotMap.numberOfWheels;

	
	Victor[] wheels = new Victor[numberWheels];
	
    public Drivetrain() {
    	this.wheels[wheelIndex.backrightwheel.getValue()] = new Victor(RobotMap.victorWheel_backright);
		this.wheels[wheelIndex.frontrightwheel.getValue()] = new Victor(RobotMap.victorWheel_frontright);
		this.wheels[wheelIndex.backleftwheel.getValue()] = new Victor(RobotMap.victorWheel_backleft);
		this.wheels[wheelIndex.frontleftwheel.getValue()] = new Victor(RobotMap.victorWheel_frontleft);
    }
    
    
	public double [] power = new double [4];

    
    /**
     * Set Drive train speed Inputs from -1 to 1
     *
     * 
     */
public void Drive(double magnitude, double theta, double rotation, double slider_power) {
		
		System.out.println("Enter Drive Train");
		
		magnitude = magnitude * (4096/RobotMap.wheelCircumference);
		
		double xPower = magnitude * Math.cos(theta + (3*Math.PI / 4))/100;
		double yPower = magnitude * Math.sin(theta - (Math.PI / 4))/100;
				
		//takes values from above doubles and corresponds them with each wheel 
		power[wheelIndex.backrightwheel.getValue()] = slider_power*(xPower - rotation);
		power[wheelIndex.frontrightwheel.getValue()] = slider_power*((yPower - rotation)*.66);
		power[wheelIndex.backleftwheel.getValue()] = slider_power*(yPower + rotation);
		power[wheelIndex.frontleftwheel.getValue()] = slider_power*((xPower + rotation)*.66);
		
		this.wheels[wheelIndex.backrightwheel.getValue()].set(power[wheelIndex.backrightwheel.getValue()]);
		this.wheels[wheelIndex.frontrightwheel.getValue()].set(power[wheelIndex.frontrightwheel.getValue()]);
		this.wheels[wheelIndex.backleftwheel.getValue()].set(power[wheelIndex.backleftwheel.getValue()]);
		this.wheels[wheelIndex.frontleftwheel.getValue()].set(power[wheelIndex.frontleftwheel.getValue()]);
		
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
    
    
    /*public void drive(double speed) {
        drive(speed, speed);
    }*/
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TeleopDrive());
    }
}

