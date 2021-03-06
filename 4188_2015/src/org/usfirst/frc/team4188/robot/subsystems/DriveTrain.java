package org.usfirst.frc.team4188.robot.subsystems;

import edu.wpi.first.wpilibj.*;

import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;
import org.usfirst.frc.team4188.robot.CHSRobotDrive;
import org.usfirst.frc.team4188.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem{
	CHSRobotDrive robotDrive = RobotMap.driveBase;
	CANTalon frontLeft = RobotMap.frontLeft;
	CANTalon frontRight = RobotMap.frontRight;
	CANTalon rearLeft = RobotMap.rearLeft;
	CANTalon rearRight = RobotMap.rearRight;
	Gyro gyro = RobotMap.drivetraingyro;
	
	static final double TICKDISTANCE = RobotMap.TICKSPERINCH;
	
	public void init (){
		gyro.reset();
	}
	 
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ManualDrive());
	}
	
	public void driveWithJoystick(double x, double y, double twist, double throttle, double direction){
        robotDrive.mecanumDrive_Cartesian(x*throttle, -y*throttle, 0.5*twist*throttle, direction);
    }
	
	public void slowAccelerate(){
		this.setRampRate(2.5);	// 0 - 12 volts in 4.8 seconds (12/2.5=4.8) 
	}
	
	public void fastAccelerate(){
		this.setRampRate(100);	// 0 - 12 volts in .12 seconds (12/100=.12)
	}
	
	public void setRampRate(double rampRate) {
		frontLeft.setVoltageRampRate(rampRate);
		frontRight.setVoltageRampRate(rampRate);
		rearLeft.setVoltageRampRate(rampRate);
		rearRight.setVoltageRampRate(rampRate);
	}
	
	public double getEncoderFR(){
		return -frontRight.getEncPosition();
	}
	
	public double getEncoderFL(){
		return frontLeft.getEncPosition();
	}
	
	public double getEncoderRR(){
		return -rearRight.getEncPosition();
	}
	
	public double getEncoderRL(){
		return rearLeft.getEncPosition();
	}
	
	public void resetEncoders() {
        frontLeft.setPosition(0);
        frontRight.setPosition(0);
        rearLeft.setPosition(0);
        rearRight.setPosition(0);
	}
	
	double total;
	int count;
	public double getDistance(){	// Returns value in inches
		double frontLeft = Robot.drivetrain.getEncoderFL();
		double frontRight = Robot.drivetrain.getEncoderFR();
		double rearLeft = Robot.drivetrain.getEncoderRL();
		double rearRight = Robot.drivetrain.getEncoderRR();
		
		count=0;
		total=0;
		countTotal(frontLeft);  
		countTotal(frontRight);  
		countTotal(rearLeft);  
		countTotal(rearRight);  
        return (total / count) / TICKDISTANCE;
	}
	private void countTotal(double input) {
		if (input != 0) {
			total += Math.abs(input);
			count++;			
		}
	}
	
	public void getEncoderValues(){        
        SmartDashboard.putNumber("frontLeftEncoder distance", frontLeft.getEncPosition());
        SmartDashboard.putNumber("frontRightEncoder distance", frontRight.getEncPosition());
        SmartDashboard.putNumber("rearLeftEncoder distance", rearLeft.getEncPosition());
        SmartDashboard.putNumber("rearRightEncoder distance", rearRight.getEncPosition());
	}

	public void autoDrive(double xSpeed, double ySpeed, double twist, double direction){
		robotDrive.mecanumDrive_Cartesian(xSpeed, ySpeed, twist, direction);
	}
	
    public void autodrive(double speed, double direction, double rotation) {
		robotDrive.mecanumDrive_Polar(speed, direction, rotation);
	}
}
