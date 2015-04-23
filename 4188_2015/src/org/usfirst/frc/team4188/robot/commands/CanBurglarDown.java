package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CanBurglarDown extends Command {
	double speed;	// 0-1
	double timeout;

    public CanBurglarDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	speed = RobotMap.CANBURGLARSPEED/2;
    	timeout = 1.2;
    }

    public CanBurglarDown(double duration, double speedVector) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	speed = speedVector;
    	timeout = duration;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	requires(Robot.canBurglar);
    	this.setInterruptible(true);
    	this.setTimeout(timeout);
    	this.setInterruptible(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.canBurglar.goDown(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.canBurglar.isAtBottom() || this.isTimedOut();	// Finish if hits limit switch or takes too long
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.canBurglar.goDown(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
