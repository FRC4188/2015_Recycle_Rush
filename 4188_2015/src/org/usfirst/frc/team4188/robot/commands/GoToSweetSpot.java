package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.CHSLog;
import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GoToSweetSpot extends Command {

	boolean doneYet1, doneYet2, isTimerStarted;
	private Timer timer;
	
    public GoToSweetSpot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	doneYet1 = false;
    	doneYet2 = false;
//    	isTimerStarted = false;
//    	timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double SWEET_SPOT = 3; //set sweet spot number for time in seconds
    	SmartDashboard.putBoolean("doneYet1", doneYet1);
    	SmartDashboard.putBoolean("doneYet2", doneYet2);
//		SmartDashboard.putBoolean("Sweet Spot Timer Started", isTimerStarted);
//		SmartDashboard.putNumber("Sweet Spot Timer Value", timer.get());
    	
    	if(!doneYet1){
    		if(!Robot.motors.getClawCloseLim()){
    			Robot.motors.runClaw(0.5); //positive to close
    		}
    		else {
    			Robot.motors.stopClaw();
    			doneYet1 = true;
    		}
    	}
    	
    	doneYet2 = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return doneYet1 && doneYet2;
    }

    // Called once after isFinished returns true
    protected void end() {
    	doneYet1 = false;
    	doneYet2 = false;
//    	isTimerStarted = false;
//    	timer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
