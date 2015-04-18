package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.CHSLog;
import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutomaticStack extends Command {

	private boolean doneYet1, doneYet2, doneYet3, doneYet4, doneYet5, doneYet6;
	Timer timer, timer2, timer3;
	private boolean isTimerStarted, isTimer2Started, isTimer3Started;
	
	boolean b;
	
    public AutomaticStack() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	timer2 = new Timer();
    	timer3 = new Timer();
    	
    	isTimerStarted = false;
    	isTimer2Started = false;
    	isTimer3Started = false;
    	
    	doneYet1 = false;
    	doneYet2 = false;
    	doneYet3 = false;
    	doneYet4 = false;
    	doneYet5 = false;
    	doneYet6 = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//CHANGE TIMERS TO ENCODERS
    	
    	//drive forward till next tote is hit
    	if(!doneYet1){
    		CHSLog.log("Automatic Stack", "Moving Forward", false, true);
//    		if(Robot.motors.isLim1Hit()) Robot.drivetrain.autoDrive(0, -0.2, 0, RobotMap.drivetraingyro.getAngle()*.03);
//    		else {
    			Robot.drivetrain.autoDrive(0, 0, 0, 0);
        		doneYet1 = true;
//    		} 
    	}
    	
    	//move lift down till stack hits bottom tote
    	if(doneYet1 && !doneYet2){
    		if(!isTimerStarted) {
    			timer.start();
    			isTimerStarted = true;
    		}
    		else{
    			CHSLog.log("Automatic Stack", "Moving Lift Down", false, true);
    			if(timer.get() < 1) Robot.motors.runLift(0.75); //positive means it goes down
    			else {
    				Robot.motors.stopLift();
    				doneYet2 = true;
    			}
    		}
    	}
    	
    	doneYet3 = true;
    	
    	//move backwards x amount
    	if(doneYet1 && doneYet2 && doneYet3 && !doneYet4){
    		if(!isTimer2Started) {
    			timer2.start();
    			isTimer2Started = true;
    		}
    		else{
    			CHSLog.log("Automatic Stack", "", false, true);
    			if(timer2.get() < 2) Robot.drivetrain.autoDrive(0, 0.3, 0, RobotMap.drivetraingyro.getAngle()*.03);
    			else {
    				Robot.drivetrain.autoDrive(0, 0, 0, 0);
    				doneYet4 = true;
    			}
    		}
    	}
    	
    	//move lift down to the ground
    	if(doneYet1 && doneYet2 && doneYet3 && doneYet4 && !doneYet5){
    		CHSLog.log("Automatic Stack", "Moving Lift Down", false, true);
    		if(Robot.motors.isLiftTop()) Robot.motors.runLift(0.75); //positive means it goes down
    		else {
   				Robot.motors.stopLift();
   				doneYet5 = true;
   			}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (doneYet1 && doneYet2 && doneYet3 && doneYet4 && doneYet5) || RobotMap.exitAuto;
    }

    // Called once after isFinished returns true
    protected void end() {
    	doneYet1 = false;
    	doneYet2 = false;
    	doneYet3 = false;
    	doneYet4 = false;
    	doneYet5 = false;
    	
    	RobotMap.exitAuto = false;
    	
    	timer.reset();
    	isTimerStarted = false;
    	timer2.reset();
    	isTimer2Started = false;
    	timer3.reset();
    	isTimer3Started = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
