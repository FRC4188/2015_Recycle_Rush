package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveBearingForDistance extends Command {
	double inches;
	double degrees;
	double speed;
	double spin;

    public AutoDriveBearingForDistance(double magnitude, double direction, double rotation, double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	inches = distance;
    	degrees = direction;
    	speed = magnitude;
    	spin = rotation;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drivetrain.autodrive(0.8, 0.0, 0.0);  
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double distance = Robot.drivetrain.getDistance();
    	return (distance >= inches);
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.autodrive(0.0, 0.0, 0.0);  
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
	}
}
