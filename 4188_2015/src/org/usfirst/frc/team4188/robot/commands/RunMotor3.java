package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.CorpsJoystick;
import org.usfirst.frc.team4188.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunMotor3 extends Command {
	
    public RunMotor3() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.motors.runMotor3WithJoystick(Robot.oi.copilotJoystick.getY());
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
