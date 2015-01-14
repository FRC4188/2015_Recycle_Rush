package org.usfirst.frc.team4188.robot.subsystems;

import org.usfirst.frc.team4188.*;

import edu.wpi.first.wpilibj.*;

import org.usfirst.frc.team4188.robot.RobotMap;
import org.usfirst.frc.team4188.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem{
	
	RobotDrive robotDrive = RobotMap.driveBase;
	Talon frontLeft = RobotMap.frontLeft;
	Talon frontRight = RobotMap.frontRight;
	Talon rearLeft = RobotMap.rearLeft;
	Talon rearRight = RobotMap.rearRight;
	Gyro gyro = RobotMap.drivetraingyro;
	
	Encoder encoderFrontRight = RobotMap.encoder1;
	Encoder encoderFrontLeft = RobotMap.encoder2;
	Encoder encoderRearRight = RobotMap.encoder3;
	Encoder encoderRearLeft = RobotMap.encoder4;
	
	DigitalInput limSwitch = RobotMap.limSwitch1;
	
	public void init (){
		gyro.reset();
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
		double EncoderValue1;
		EncoderValue1 = encoderFrontRight.getDistance();
		return EncoderValue1;
	}
	
	public double getEncoderFL(){
		double EncoderValue1;
		EncoderValue1 = encoderFrontLeft.getDistance();
		return EncoderValue1;
	}
	
	public double getEncoderRR(){
		double EncoderValue1;
		EncoderValue1 = encoderRearRight.getDistance();
		return EncoderValue1;
	}
	
	public double getEncoderRL(){
		double EncoderValue1;
		EncoderValue1 = encoderRearLeft.getDistance();
		return EncoderValue1;
	}
	
	public void autoDrive(double xSpeed, double ySpeed, double throttle, double direction){
		robotDrive.mecanumDrive_Cartesian(xSpeed, ySpeed, throttle, direction);
	}
	
	public boolean getLimSwitch(){
		boolean LimSwitch;
		LimSwitch = limSwitch.get();
		return LimSwitch;
	}
}
