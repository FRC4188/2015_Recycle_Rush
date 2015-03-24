package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.CorpsLog;
import org.usfirst.frc.team4188.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToteLift extends Command {

	Timer timer;
	boolean isTimerStarted, doneYet;
	
    public ToteLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	isTimerStarted = false;
    	doneYet = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		if(!isTimerStarted) {
			timer.start();
			isTimerStarted = true;
		}
		else{
			CorpsLog.log("Automatic Stack", "Moving Lift Up", false, true);
			if(timer.get() < 1.5) Robot.motors.runMotor1(-0.75); //negative means it goes up
			else {
				Robot.motors.stopMotor1();
				doneYet = true;
			}
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return doneYet;
    }

    // Called once after isFinished returns true
    protected void end() {
    	doneYet = false;
    	isTimerStarted = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
