package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutomaticGrab extends Command {

	private boolean doneYet1;
	private boolean doneYet2;
	
    public AutomaticGrab() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	doneYet1 = false;
    	doneYet2 = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(!doneYet1){
    		if(Robot.motors.isLim1Hit()) Robot.drivetrain.autoDrive(0, 0.5, 0, RobotMap.drivetraingyro.getAngle()*.03);
    		else Robot.drivetrain.autoDrive(0, 0, 0, 0);
    		doneYet1 = true;
    	}
    	
    	if(doneYet1 && !doneYet2){
    		if(Robot.motors.isLim2Hit()) Robot.motors.runMotor2(0.3);
    		else Robot.motors.stopMotor2();
    		doneYet2 = true;
    	}
    	
    	//lift up x amount
    	
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
