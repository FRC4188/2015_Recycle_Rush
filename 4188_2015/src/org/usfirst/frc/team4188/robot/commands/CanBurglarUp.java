package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CanBurglarUp extends Command {

    public CanBurglarUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//    	requires(Robot.canBurglar);
    }

    public CanBurglarUp(double duration) {	// Stop moving after timeout
//    	requires(Robot.canBurglar);
    	this.setTimeout(duration);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setInterruptible(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.canBurglar.goUp(RobotMap.canBurglarSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		// Finish if hit top limit switch or if timer has been set and then expired
    	return Robot.canBurglar.isAtTop() || this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.canBurglar.goUp(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.canBurglar.goUp(0.0);
    }
}
