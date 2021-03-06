package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftUp extends Command {

    public LiftUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.setInterruptible(true);
    }

    public LiftUp(double duration) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.setInterruptible(true);
    	this.setTimeout(duration);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.motors.liftUp(0.75);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.motors.isLiftTop() || this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.motors.stopLift();;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
