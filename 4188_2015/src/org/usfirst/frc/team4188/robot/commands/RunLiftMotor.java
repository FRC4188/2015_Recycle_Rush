package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunLiftMotor extends Command {
	
    public RunLiftMotor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//LIFT MOTORS
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.motors.runMotor1WithJoystick(-Robot.oi.copilotJoystick.getY()*Robot.oi.copilotJoystick.getThrottle());
    	
    	if(!Robot.motors.isLim4Hit()) {
    		if (-Robot.oi.copilotJoystick.getY() < 0) Robot.motors.stopMotor1(); //hit bottom
    	}
    	
    	if(!Robot.motors.isLim5Hit()) {
    		if (-Robot.oi.copilotJoystick.getY() > 0) Robot.motors.stopMotor1(); //hit top
    	}
    	
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
