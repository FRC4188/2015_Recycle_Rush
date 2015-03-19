package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.CorpsLog;
import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetClawLift extends Command {

	private boolean doneYet1, doneYet2;
	
    public ResetClawLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	doneYet1 = false;
    	doneYet2 = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!doneYet1){
    		if(!Robot.motors.getClawOpenLim()) Robot.motors.runMotor2(-0.6); //negative means open
    		else {
    			Robot.motors.stopMotor2();
        		doneYet1 = true;
    		} 
    	}
    	
    	//move lift down till stack hits bottom tote
    	if(doneYet1 && !doneYet2){
    		if(!Robot.motors.getLiftBottomLim()) Robot.motors.runMotor1(0.75); //positive means go down
    		else {
    			Robot.motors.stopMotor1();
        		doneYet2 = true;
    		} 
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return doneYet1 && doneYet2;
    }

    // Called once after isFinished returns true
    protected void end() {
    	doneYet1 = false;
    	doneYet2 = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
