package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.CorpsLog;
import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutomaticGrabTwoStep extends Command {
	
	private boolean doneYet1, doneYet2, doneYet3, doneYet4, doneYet5, doneYet6, doneYet7;
	Timer timer, timer2, timer3;
	private boolean isTimerStarted, isTimer2Started, isTimer3Started;
	
    public AutomaticGrabTwoStep() {
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
    	doneYet7 = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//close claw till front two lim switches are hit
    	if(!doneYet1){
    		if(Robot.motors.isLim7Hit() && Robot.motors.isLim8Hit()) Robot.motors.runMotor2(0.3); //positive means close
    		else {
    			Robot.motors.stopMotor2();
    			doneYet1 = true;
    		}
    	}
    	
    	//drive backwards for 2 seconds
    	if(doneYet1 && !doneYet2){
    		if(!isTimerStarted) {
    			timer.start();
    			isTimerStarted = true;
    		}
    		else{
    			if(timer.get() < 2)  Robot.drivetrain.autoDrive(0, -0.3, 0, RobotMap.drivetraingyro.getAngle()*.03);
        		else {
        			Robot.drivetrain.autoDrive(0, 0, 0, 0);
        			doneYet2 = true;
        		}
    		}
    	}
    	
    	//open claw for 2 seconds
    	if(doneYet1 && doneYet2 && !doneYet3){
    		if(!isTimer2Started) {
    			timer2.start();
    			isTimer2Started = true;
    		}
    		else{
    			if(timer2.get() < 2) Robot.motors.runMotor2(-0.3); //negative means open
    			else {
    				Robot.motors.stopMotor2();
    				doneYet3 = true;
    			}
    		}
    	}
    	
    	//drive backward for 1 second
    	if(doneYet1 && doneYet2 && doneYet3 && !doneYet4){
    		if(!isTimer3Started) {
    			timer3.start();
    			isTimer3Started = true;
    		}
    		else{
    			if(timer3.get() < 1) Robot.drivetrain.autoDrive(0, 0.3, 0, RobotMap.drivetraingyro.getAngle()*.03); //positive means drive backward
    			else {
    				Robot.drivetrain.autoDrive(0, 0, 0, 0);
    				doneYet4 = true;
    			}
    		}
    	}
    	
    	//go forward till front switch is hit
    	if(doneYet1 && doneYet2 && doneYet3 && doneYet4 && !doneYet5){
    		if(Robot.motors.isLim1Hit()) Robot.drivetrain.autoDrive(0, -0.3, 0, RobotMap.drivetraingyro.getAngle()*.03); //negative means drive forward
    		else {
    			Robot.drivetrain.autoDrive(0, 0, 0, 0);
    			doneYet5 = true;
    		}
    	}
    	
    	//close claw till both sides of claw switches are hit
    	if(doneYet1 && doneYet2 && doneYet3 && doneYet4 && doneYet5 && !doneYet6){
    		if(Robot.motors.isLim2Hit() || Robot.motors.isLim6Hit()) Robot.motors.runMotor2(0.3); //positive means close
    		else {
    			Robot.motors.stopMotor2();
    			doneYet6 = true;
    		}
    	}
    	
    	//lift up x amount
    	if(doneYet1 && doneYet2 && doneYet3 && doneYet4 && doneYet5 && doneYet6 && !doneYet7){
    		if(!isTimer3Started) {
    			timer3.start();
    			isTimer3Started = true;
    		}
    		else{
    			if(timer3.get() < 3) Robot.motors.runMotor1(-0.75); //negative means it goes up
    			else {
    				Robot.motors.stopMotor1();
    				doneYet4 = true;
    			}
    		}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (doneYet1 && doneYet2 && doneYet3 && doneYet4 && doneYet5 && doneYet6 && doneYet7) || RobotMap.exitAuto;
    }

    // Called once after isFinished returns true
    protected void end() {
    	doneYet1 = false;
    	doneYet2 = false;
    	doneYet3 = false;
    	doneYet4 = false;
    	doneYet5 = false;
    	doneYet6 = false;
    	doneYet7 = false;
    	
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
