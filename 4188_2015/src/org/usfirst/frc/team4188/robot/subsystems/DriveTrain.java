package org.usfirst.frc.team4188.robot.subsystems;

import edu.wpi.first.wpilibj.*;

import org.usfirst.frc.team4188.robot.RobotMap;
import org.usfirst.frc.team4188.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem{
	
	RobotDrive robotDrive = RobotMap.driveBase;
	CANTalon frontLeft = RobotMap.frontLeft;
	CANTalon frontRight = RobotMap.frontRight;
	CANTalon rearLeft = RobotMap.rearLeft;
	CANTalon rearRight = RobotMap.rearRight;
	Gyro gyro = RobotMap.drivetraingyro;
	
/**	Encoder encoderFrontRight = RobotMap.encoder1;
	Encoder encoderFrontLeft = RobotMap.encoder2;
	Encoder encoderRearRight = RobotMap.encoder3;
	Encoder encoderRearLeft = RobotMap.encoder4;**/
	
	DigitalInput limSwitch = RobotMap.limSwitch1;
	
	AnalogInput potentiometer = RobotMap.potentiometer;
	
	public void init (){
		gyro.reset();
		
	/**	encoderFrontRight.reset();
	    encoderFrontLeft.reset();
	    encoderRearRight.reset();
	    encoderRearLeft.reset();**/
	}
	 
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ManualDrive());
    }
	
	public void driveWithJoystick(double x, double y, double twist, double throttle, double direction){
        robotDrive.mecanumDrive_Cartesian(0.5*x*throttle, -0.5*y*throttle, 0.5*twist*throttle, direction);
    }
	
	public void slowAccelerate(){
		frontLeft.setVoltageRampRate(2.5);
		frontRight.setVoltageRampRate(2.5);
		rearLeft.setVoltageRampRate(2.5);
		rearRight.setVoltageRampRate(2.5);
	}
	
	public void fastAccelerate(){
		frontLeft.setVoltageRampRate(10);
		frontRight.setVoltageRampRate(10);
		rearLeft.setVoltageRampRate(10);
		rearRight.setVoltageRampRate(10);
	}
	
	public double getEncoderFR(){
		return frontRight.getEncPosition();
	}
	
	public double getEncoderFL(){
		return frontLeft.getEncPosition();
	}
	
	public double getEncoderRR(){
		return rearRight.getEncPosition();
	}
	
	public double getEncoderRL(){
		return rearLeft.getEncPosition();
	}
	
	public void getEncoderValues(){        
        SmartDashboard.putNumber("gyro",gyro.getAngle());
//        SmartDashboard.putNumber("frontLeftEncoder distance", encoderFrontLeft.getDistance());
//        SmartDashboard.putNumber("frontRightEncoder distance", encoderFrontRight.getDistance());
//        SmartDashboard.putNumber("rearLeftEncoder distance", encoderRearLeft.getDistance());
//        SmartDashboard.putNumber("rearRightEncoder distance", encoderRearRight.getDistance());
        
        SmartDashboard.putNumber("frontLeftEncoder distance", frontLeft.getEncPosition());
        SmartDashboard.putNumber("frontRightEncoder distance", frontRight.getEncPosition());
        SmartDashboard.putNumber("rearLeftEncoder distance", rearLeft.getEncPosition());
        SmartDashboard.putNumber("rearRightEncoder distance", rearRight.getEncPosition());
 }
	
	/**public void resetEncoders()
    {
		encoderFrontRight.reset();
	    encoderFrontLeft.reset();
	    encoderRearRight.reset();
	    encoderRearLeft.reset();
    }**/
	
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
