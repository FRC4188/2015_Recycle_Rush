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
}
