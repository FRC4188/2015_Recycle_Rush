package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftDown extends Command {
boolean doneYet;
	
    public LiftDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	doneYet = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

// FIXFIX
    
//    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//		if(Robot.motors.isLim4Hit()) Robot.motors.runMotor1(0.75); //positive means it goes down
//		else {
//				Robot.motors.stopMotor1();
//				doneYet = true;
//		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return doneYet;
    }

    // Called once after isFinished returns true
    protected void end() {
    	doneYet = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
