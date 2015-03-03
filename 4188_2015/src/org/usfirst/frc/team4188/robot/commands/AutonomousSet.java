package org.usfirst.frc.team4188.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousSet extends Command {
	
public static int state, stateAuto;

    public AutonomousSet(int State) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	state = State;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	stateAuto = state;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
