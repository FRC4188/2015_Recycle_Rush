package org.usfirst.frc.team4188.robot.subsystems;

import edu.wpi.first.wpilibj.*;

import org.usfirst.frc.team4188.robot.RobotMap;
import org.usfirst.frc.team4188.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem{
	
	RobotDrive robotDrive = RobotMap.driveBase;
	CANTalon frontLeft = RobotMap.frontLeft;
	CANTalon frontRight = RobotMap.frontRight;
	CANTalon rearLeft = RobotMap.rearLeft;
	CANTalon rearRight = RobotMap.rearRight;
	Gyro gyro = RobotMap.drivetraingyro;
	
	Encoder encoderFrontRight = RobotMap.encoder1;
	Encoder encoderFrontLeft = RobotMap.encoder2;
	Encoder encoderRearRight = RobotMap.encoder3;
	Encoder encoderRearLeft = RobotMap.encoder4;
	
	DigitalInput limSwitch = RobotMap.limSwitch1;
	
	AnalogInput potentiometer = RobotMap.potentiometer;
	
	public void init (){
		gyro.reset();
		
		encoderFrontRight.setDistancePerPulse(1.0);
		encoderFrontLeft.setDistancePerPulse(1.0);
		encoderRearRight.setDistancePerPulse(1.0);
		encoderRearLeft.setDistancePerPulse(1.0);
		
		encoderFrontRight.reset();
	    encoderFrontLeft.reset();
	    encoderRearRight.reset();
	    encoderRearLeft.reset();
	}
	 
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ManualDrive());
    }
	
	public void driveWithJoystick(double x, double y, double twist, double throttle, double direction){
        robotDrive.mecanumDrive_Cartesian(x*throttle, -y*throttle, twist*throttle, direction);
    }
	
	public double getEncoderFR(){
		return encoderFrontRight.getDistance();
	}
	
	public double getEncoderFL(){
		return encoderFrontLeft.getDistance();
	}
	
	public double getEncoderRR(){
		return encoderRearRight.getDistance();
	}
	
	public double getEncoderRL(){
		return encoderRearLeft.getDistance();
	}
	
	public void getEncoderValues(){        
        SmartDashboard.putNumber("gyro",gyro.getAngle());
        SmartDashboard.putNumber("frontLeftEncoder distance", encoderFrontRight.getDistance());
        SmartDashboard.putNumber("frontRightEncoder distance", encoderFrontLeft.getDistance());
        SmartDashboard.putNumber("rearLeftEncoder distance", encoderRearRight.getDistance());
        SmartDashboard.putNumber("rearRightEncoder distance", encoderRearLeft.getDistance());
 }
	
	public void resetEncoders()
    {
		encoderFrontRight.reset();
	    encoderFrontLeft.reset();
	    encoderRearRight.reset();
	    encoderRearLeft.reset();
    }
	
	public void autoDrive(double xSpeed, double ySpeed, double twist, double direction){
		robotDrive.mecanumDrive_Cartesian(xSpeed, ySpeed, twist, direction);
	}
	
	public boolean getLimSwitch(){
		return limSwitch.get();
	}
	
	public int getPotentiometerValue(){
		return potentiometer.getValue();
	}
}
