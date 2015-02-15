package org.usfirst.frc.team4188.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutomaticGrabExit extends Command {

	public static boolean doneYetAutoGrab;
	
    public AutomaticGrabExit() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	doneYetAutoGrab = true;
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	doneYetAutoGrab = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
