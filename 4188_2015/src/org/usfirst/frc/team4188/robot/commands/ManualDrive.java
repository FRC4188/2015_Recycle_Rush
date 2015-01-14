package org.usfirst.frc.team4188.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.*;

import org.usfirst.frc.team4188.*;
import org.usfirst.frc.team4188.robot.CorpsLog;
import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;

/**
 *
 */
public class ManualDrive extends Command {
	
	Joystick pilotStick = Robot.oi.pilotJoystick;
	
    public ManualDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.driveWithJoystick(pilotStick.getX(), pilotStick.getY(), pilotStick.getTwist(), pilotStick.getThrottle(), RobotMap.drivetraingyro.getAngle()*.03);
    	
    	CorpsLog.log("Front Right Encoder", Robot.drivetrain.getEncoderFR(), true, false);
    	CorpsLog.log("Front Left Encoder", Robot.drivetrain.getEncoderFL(), true, false);
    	CorpsLog.log("Rear Right Encoder", Robot.drivetrain.getEncoderRR(), true, false);
    	CorpsLog.log("Rear Left Encoder", Robot.drivetrain.getEncoderRL(), true, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
