package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.CorpsLog;
import org.usfirst.frc.team4188.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SensorDisplay extends Command {

    public SensorDisplay() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	CorpsLog.log("Front Right Encoder", Robot.drivetrain.getEncoderFR(), true, false);
//    	CorpsLog.log("Front Left Encoder", Robot.drivetrain.getEncoderFL(), true, false);
//    	CorpsLog.log("Rear Right Encoder", Robot.drivetrain.getEncoderRR(), true, false);
//    	CorpsLog.log("Rear Left Encoder", Robot.drivetrain.getEncoderRL(), true, false);
    	
    	Robot.drivetrain.getEncoderValues();
    	
    	CorpsLog.log("Limit Switch", Robot.drivetrain.getLimSwitch(), true, false);
    	CorpsLog.log("Potentiometer", Robot.drivetrain.getPotentiometerValue(), true, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
