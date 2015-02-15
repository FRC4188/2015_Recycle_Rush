package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.CorpsLog;
import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutomaticGrab extends Command {

	private boolean doneYet1;
	private boolean doneYet2, doneYet3, doneYet4;
	
	private boolean isTimer3Started;
	
	boolean a;
	
	Timer timer3;
	
    public AutomaticGrab() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	doneYet1 = false;
    	doneYet2 = false;
    	doneYet3 = false;
    	doneYet4 = false;
    	
    	timer3 = new Timer();
    	isTimer3Started = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	boolean a = AutomaticGrabExit.doneYetAutoGrab;
    	
    	doneYet1 = true; 
    	
    	if(doneYet1 && !doneYet2){
    		CorpsLog.log("Automatic Grab", "Moving Forward", false, true);
    		if(Robot.motors.isLim1Hit()) Robot.drivetrain.autoDrive(0, -0.3, 0, RobotMap.drivetraingyro.getAngle()*.03);
    		else {
    			Robot.drivetrain.autoDrive(0, 0, 0, 0);
    			doneYet2 = true;
    		}
    	}
    	
    	//close claw till tote is hit
    	if(doneYet1 && doneYet2 && !doneYet3){
    		CorpsLog.log("Automatic Grab", "Closing Claw", false, true);
    		if(Robot.motors.isLim2Hit() || Robot.motors.isLim6Hit()) Robot.motors.runMotor2(0.3);
    		else {
    			Robot.motors.stopMotor2();
    			doneYet3 = true;
    		}
    	}
    	
    	//lift up x amount
    	if(doneYet1 && doneYet2 && doneYet3 && !doneYet4){
    		if(!isTimer3Started) {
    			timer3.start();
    			isTimer3Started = true;
    		}
    		else{
    			CorpsLog.log("Automatic Grab", "Lift Up", false, true);
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
        return (doneYet1 && doneYet2 && doneYet3 && doneYet4) || a;
    }

    // Called once after isFinished returns true
    protected void end() {
    	doneYet1 = false;
    	doneYet2 = false;
    	doneYet3 = false;
    	doneYet4 = false;
    	timer3.reset();
    	isTimer3Started = false;
    	a = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
