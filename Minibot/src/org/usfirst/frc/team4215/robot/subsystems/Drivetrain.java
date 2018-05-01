package org.usfirst.frc.team4215.robot.subsystems;

import org.usfirst.frc.team4215.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import org.usfirst.frc.team4215.robot.RobotMap;
import org.usfirst.frc.team4215.robot.commands.TeleopDrive;

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
	/*
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
	

	
	Victor leftMotor;
    Victor rightMotor;
    Victor rightMotor2;
    Victor leftMotor2;
    
	int numberWheels = RobotMap.numberOfWheels;

	
	Victor[] wheels = new Victor[numberWheels];
	
    public Drivetrain() {
    	this.wheels[wheelIndex.backrightwheel.getValue()] = new Victor(RobotMap.victorWheel_backright);
		this.wheels[wheelIndex.frontrightwheel.getValue()] = new Victor(RobotMap.victorWheel_frontright);
		this.wheels[wheelIndex.backleftwheel.getValue()] = new Victor(RobotMap.victorWheel_backleft);
		this.wheels[wheelIndex.frontleftwheel.getValue()] = new Victor(RobotMap.victorWheel_frontleft);
    }
    
    
	public double [] power = new double [4];

    
    *//**
     * Set DriveMecanum train speed Inputs from -1 to 1
     *
     * 
     *//*
public void DriveMecanum(double magnitude, double theta, double rotation, double slider_power) {
		
		System.out.println("Enter DriveMecanum Train");
		
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
    
    *//**
     * Scaling because Victor does not response to volts less than 4%
     * either direction.
     *
     * @param speed
     * @return scaled speed
     *//*
    private static double scaling(double speed) {
        if (speed == 0) return 0d;
        else return Math.signum(speed)
                * ((Math.abs(speed) * .96) + .04);
    }
    
    *//**
     * You can use this function when left speed and right speed are
     * the same.
     *
     * @author James
     * @param speed
     */
    
//the port numbers of each of the wheels
	//also used as the index for the wheels array
	private enum WheelType {
		
		backrightwheel(RobotMap.talonWheel_backright),
		frontrightwheel(RobotMap.talonWheel_frontright),
		backleftwheel(RobotMap.talonWheel_backleft),
		frontleftwheel(RobotMap.talonWheel_frontleft); 
		
		private int wheelId;
		private TalonSRX wheel;
		private WheelType (int id) {
			this.wheelId = id;
			this.wheel = new TalonSRX(this.wheelId);			
		}
		
		public int getId() {
			return this.wheelId;
		}
		public TalonSRX getWheel() {
			return this.wheel;
		}
	}
		
	public Drivetrain() {
				
		WheelType.frontleftwheel.getWheel().setInverted(true);
		WheelType.backleftwheel.getWheel().setInverted(true);		
	}
	
	/**
	 * Dives the robot
	 * @param magnitude
	 * @param theta
	 * @param rotation
	 * @param slider_power
	 */
	
	public void DriveMecanum(double magnitude, double theta, double rotation, double slider_power) {
		
		//System.out.println("Enter DriveMecanum Train");
		rotation *= -.5;
		if (magnitude <= .08 && magnitude >= -.08) {
			theta = 0;
			magnitude = 0;
		}
		
		//not sure what this is supposed to be 
		//if (theta <= Math.PI/30 && theta >= -Math.PI/30)
				
		//rotation = 0;
		double xPower = magnitude * Math.sin(-theta - Math.PI / 4);
		double yPower = magnitude * Math.cos(-theta - Math.PI / 4);
	
		//takes values from above doubles and corresponds them with each wheel 		
		WheelType.backrightwheel.getWheel().set(ControlMode.PercentOutput, xPower - rotation);
		WheelType.frontrightwheel.getWheel().set(ControlMode.PercentOutput, yPower + rotation);
		WheelType.backleftwheel.getWheel().set(ControlMode.PercentOutput, yPower - rotation);
		WheelType.frontleftwheel.getWheel().set(ControlMode.PercentOutput, xPower + rotation);
		
	}
	
	public void DriveTank(double magnitudeLeft, double magnitudeRight, double theta, double adjtheta) {
		//double magnitude = Math.abs(magnitudeLeft) + Math.abs(magnitudeRight);  // TODO: Make this less questionable
		if (Math.abs(magnitudeLeft) <= .08 && Math.abs(magnitudeRight) <= .08) {
			magnitudeLeft = 0;
			magnitudeRight = 0;
		}
		
		if (Math.abs(theta) > Math.PI/2) {
		magnitudeRight *= -1;
		}
		if (Math.abs(adjtheta) > Math.PI/2) {
			magnitudeLeft *= -1;
			}
		
		// TODO: Add equalization between magnitudes when close together
		
		WheelType.backrightwheel.getWheel().set(ControlMode.PercentOutput, magnitudeRight);
		WheelType.frontrightwheel.getWheel().set(ControlMode.PercentOutput, magnitudeRight);
		WheelType.frontleftwheel.getWheel().set(ControlMode.PercentOutput, magnitudeLeft);
		WheelType.backleftwheel.getWheel().set(ControlMode.PercentOutput, magnitudeLeft);
		
	}

	public void Stop() {
		DriveMecanum(0,0,0,0);
	}
	double deaccel;
	double velocity;
	
	public void brake(double time, double displacement) {
		velocity =  WheelType.backrightwheel.getWheel().getSelectedSensorVelocity(WheelType.backrightwheel.getId());
		deaccel = ((displacement-velocity*time-getDistance())/Math.pow(time, 2));
		DriveMecanum(Math.abs(deaccel), Math.PI, 0, 1);	
	}
	
	public void setRampRate(int rate) {
		for (WheelType w : WheelType.values()) { 
			w.getWheel().configOpenloopRamp(rate, 0);
		}
	}	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new TeleopDrive());
	}
	
	public void resetDistance()
	{
		for (WheelType w : WheelType.values()) { 
			w.getWheel().getSensorCollection().setQuadraturePosition(0, 0);
		}
		return;
	}

	public double getDistance()
	{
		int ticks = Math.abs(WheelType.frontleftwheel.getWheel().getSensorCollection().getQuadraturePosition());
		// convert encoder ticks
		double distance = ticks/4096 * RobotMap.wheelCircumference;
		return distance;
	}

	//
	// logging functions
	//
	/*public void logTalonBusVoltages() {
		for (WheelType w : WheelType.values()) {
			SmartDashboard.putNumber("Wheel Voltage  ( " + w.toString() + " )   :", w.getWheel().getBusVoltage());
		}
	}*/

	public void logTalonMotorOutputPercent() {
		for (WheelType w : WheelType.values()) {
			SmartDashboard.putNumber("Wheel Power  ( " + w.toString() + " )   :", w.getWheel().getMotorOutputPercent());
		}
	}

	//	public double[] getMotorOutputPercents() {
//		double[] outputs = new double[4];
//		outputs[0] = this.wheels[TalonSRXWheelEnum.backrightwheel.getWheel()].getMotorOutputPercent();
//		outputs[1] = this.wheels[TalonSRXWheelEnum.frontrightwheel.getWheel()].getMotorOutputPercent();
//		outputs[2] = this.wheels[TalonSRXWheelEnum.backleftwheel.getWheel()].getMotorOutputPercent();
//		outputs[3] = this.wheels[TalonSRXWheelEnum.frontleftwheel.getWheel()].getMotorOutputPercent();
//		return outputs;
//	}
//	
//	public double[] getMotorOutputCurrents() {
//		double[] outputs = new double[4];
//		outputs[0] = this.wheels[TalonSRXWheelEnum.backrightwheel.getWheel()].getOutputCurrent();
//		outputs[1] = this.wheels[TalonSRXWheelEnum.frontrightwheel.getWheel()].getOutputCurrent();
//		outputs[2] = this.wheels[TalonSRXWheelEnum.backleftwheel.getWheel()].getOutputCurrent();
//		outputs[3] = this.wheels[TalonSRXWheelEnum.frontleftwheel.getWheel()].getOutputCurrent();
//		return outputs;
//	}

    
    /*public void DriveMecanum(double speed) {
        DriveMecanum(speed, speed);
    }*/
	}