package org.usfirst.frc.team4188.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.*;

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
    	//if(Math.abs(pilotStick.getX()*pilotStick.getThrottle()) > 0.3 || Math.abs(pilotStick.getY()*pilotStick.getThrottle()) > 0.3 || Math.abs(pilotStick.getTwist()*pilotStick.getThrottle()) > 0.3) Robot.drivetrain.slowAccelerate();
    	//else Robot.drivetrain.fastAccelerate();
    	
    	//CHANGE IN COMPETITION Y VALUE JOYSTICK FROM NEGATIVE TO POSITIVE
    	
    	Robot.drivetrain.driveWithJoystick(pilotStick.getX(), -pilotStick.getY(), pilotStick.getTwist(), pilotStick.getThrottle(), RobotMap.drivetraingyro.getAngle()*.03);
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
