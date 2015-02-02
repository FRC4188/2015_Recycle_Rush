package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDrive extends Command {

    private double startFrontLeft;
    private double startFrontRight;
    private double startRearLeft;
    private double startRearRight;
    
    private double twistValue;
    private boolean doneYet;
    
    private int distance;
    private double speed;
    private int state;
	
    public AutoDrive(int Distance, double Speed, int State) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	distance = Distance;
    	speed = Speed;
    	state = State;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.drivetrain.resetEncoders();

       startFrontLeft = Robot.drivetrain.getEncoderFL();
       startFrontRight = Robot.drivetrain.getEncoderFR();
       startRearLeft = Robot.drivetrain.getEncoderRL();
       startRearRight = Robot.drivetrain.getEncoderRR();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
	    if (state == 1){ //move forward
	    	
	    	SmartDashboard.putNumber("start front left", startFrontLeft);
	        SmartDashboard.putNumber("start front right", startFrontRight);     
	       
	        if (((Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderFR()) > 5) &&
	                ((Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderFR()) < 10)) twistValue = 0.05;
	        if (((Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderFL()) > 5) &&
	                ((Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderFL()) < 10)) twistValue = -0.05;
	        if (((Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderFR()) > 10) &&
	                ((Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderFR()) < 15)) twistValue = 0.1;
	        if (((Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderFL()) > 10) &&
	                ((Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderFL()) < 15)) twistValue = -0.1;
	        if (((Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderFR()) > 15) &&
	                ((Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderFR()) < 20)) twistValue = 0.15;
	        if (((Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderFL()) > 15) &&
	                ((Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderFL()) < 20)) twistValue = -0.15;
	        if (((Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderFR()) > 20) &&
	                ((Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderFR()) < 25)) twistValue = 0.2;
	        if (((Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderFL()) > 20) &&
	                ((Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderFL()) < 25)) twistValue = -0.2; 
	        
	        
	        if (((Robot.drivetrain.getEncoderFL()- startFrontLeft) > -.25*distance) && ((Robot.drivetrain.getEncoderFR() - startFrontRight) > -.25*distance)) Robot.drivetrain.autoDrive(0, speed, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderFL()- startFrontLeft) > -.4*distance) && ((Robot.drivetrain.getEncoderFR() - startFrontRight) > -.5*distance)) Robot.drivetrain.autoDrive(0, .75*speed, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderFL()- startFrontLeft) > -.7*distance) && ((Robot.drivetrain.getEncoderFR() - startFrontRight) > -.7*distance)) Robot.drivetrain.autoDrive(0, .5*speed, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderFL()- startFrontLeft) > -.8*distance) && ((Robot.drivetrain.getEncoderFR() - startFrontRight) > -.9*distance)) Robot.drivetrain.autoDrive(0, .33*speed, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderFL()- startFrontLeft) > -distance) && ((Robot.drivetrain.getEncoderFR() - startFrontRight) > -distance)) Robot.drivetrain.autoDrive(0, .16*speed, twistValue , 0);
	        else {                                                                                                                      
	            Robot.drivetrain.autoDrive(0, 0, 0, 0);
	            doneYet = true;
	        }
	    }
    
	    if (state == 2){ //move right, front goes backward, rear goes forward
	    	
	    	SmartDashboard.putNumber("start front right", startFrontRight);
	        SmartDashboard.putNumber("start rear right", startRearRight);     
	        
	        //need to experiment with twist directions
	       
	        if (((-Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderRR()) > 5) &&
	                ((-Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderRR()) < 10)) twistValue = 0.05;
	        if (((Robot.drivetrain.getEncoderRR() - -Robot.drivetrain.getEncoderFR()) > 5) &&
	                ((Robot.drivetrain.getEncoderRR() - -Robot.drivetrain.getEncoderFR()) < 10)) twistValue = -0.05;
	        if (((-Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderRR()) > 10) &&
	                ((-Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderRR()) < 15)) twistValue = 0.1;
	        if (((Robot.drivetrain.getEncoderRR() - -Robot.drivetrain.getEncoderFR()) > 10) &&
	                ((Robot.drivetrain.getEncoderRR() - -Robot.drivetrain.getEncoderFR()) < 15)) twistValue = -0.1;
	        if (((-Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderRR()) > 15) &&
	                ((-Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderRR()) < 20)) twistValue = 0.15;
	        if (((Robot.drivetrain.getEncoderRR() - -Robot.drivetrain.getEncoderFR()) > 15) &&
	                ((Robot.drivetrain.getEncoderRR() - -Robot.drivetrain.getEncoderFR()) < 20)) twistValue = -0.15;
	        if (((-Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderRR()) > 20) &&
	                ((-Robot.drivetrain.getEncoderFR() - Robot.drivetrain.getEncoderRR()) < 25)) twistValue = 0.2;
	        if (((Robot.drivetrain.getEncoderRR() - -Robot.drivetrain.getEncoderFR()) > 20) &&
	                ((Robot.drivetrain.getEncoderRR() - -Robot.drivetrain.getEncoderFR()) < 25)) twistValue = -0.2;
	        
	        //need to experiment with which ways the encoder values go
	        
	        if ((-(Robot.drivetrain.getEncoderFR()- startFrontRight) < .25*distance) && ((Robot.drivetrain.getEncoderRR() - startRearRight) > -.25*distance)) Robot.drivetrain.autoDrive(speed, 0, twistValue , 0);
	        else if ((-(Robot.drivetrain.getEncoderFR()- startFrontRight) < .4*distance) && ((Robot.drivetrain.getEncoderRR() - startRearRight) > -.5*distance)) Robot.drivetrain.autoDrive(.75*speed, 0, twistValue , 0);
	        else if ((-(Robot.drivetrain.getEncoderFR()- startFrontRight) < .7*distance) && ((Robot.drivetrain.getEncoderRR() - startRearRight) > -.7*distance)) Robot.drivetrain.autoDrive(.5*speed, 0, twistValue , 0);
	        else if ((-(Robot.drivetrain.getEncoderFR()- startFrontRight) < .8*distance) && ((Robot.drivetrain.getEncoderRR() - startRearRight) > -.9*distance)) Robot.drivetrain.autoDrive(.33*speed, 0, twistValue , 0);
	        else if ((-(Robot.drivetrain.getEncoderFR()- startFrontRight) < distance) && ((Robot.drivetrain.getEncoderRR() - startRearRight) > -distance)) Robot.drivetrain.autoDrive(.16*speed, 0, twistValue , 0);
	        else {                                                                                                                      
	            Robot.drivetrain.autoDrive(0, 0, 0, 0);
	            doneYet = true;
	        }
	    }
	    
	    if (state == 3){ //move left, front goes backward, rear goes forward
	    	
	    	SmartDashboard.putNumber("start front left", startFrontLeft);
	        SmartDashboard.putNumber("start rear left", startRearLeft);     
	        
	        //need to experiment with twist directions
	       
	        if (((-Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderRL()) > 5) &&
	                ((-Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderRL()) < 10)) twistValue = -0.05;
	        if (((Robot.drivetrain.getEncoderRL() - -Robot.drivetrain.getEncoderFL()) > 5) &&
	                ((Robot.drivetrain.getEncoderRL() - -Robot.drivetrain.getEncoderFL()) < 10)) twistValue = 0.05;
	        if (((-Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderRL()) > 10) &&
	                ((-Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderRL()) < 15)) twistValue = -0.1;
	        if (((Robot.drivetrain.getEncoderRL() - -Robot.drivetrain.getEncoderFL()) > 10) &&
	                ((Robot.drivetrain.getEncoderRL() - -Robot.drivetrain.getEncoderFL()) < 15)) twistValue = 0.1;
	        if (((-Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderRL()) > 15) &&
	                ((-Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderRL()) < 20)) twistValue = -0.15;
	        if (((Robot.drivetrain.getEncoderRL() - -Robot.drivetrain.getEncoderFL()) > 15) &&
	                ((Robot.drivetrain.getEncoderRL() - -Robot.drivetrain.getEncoderFL()) < 20)) twistValue = 0.15;
	        if (((-Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderRL()) > 20) &&
	                ((-Robot.drivetrain.getEncoderFL() - Robot.drivetrain.getEncoderRL()) < 25)) twistValue = -0.2;
	        if (((Robot.drivetrain.getEncoderRL() - -Robot.drivetrain.getEncoderFL()) > 20) &&
	                ((Robot.drivetrain.getEncoderRL() - -Robot.drivetrain.getEncoderFL()) < 25)) twistValue = 0.2;
	        
	        //need to experiment with which ways the encoder values go
	        
	        if (((Robot.drivetrain.getEncoderFL()- startFrontLeft) < .25*distance) && ((Robot.drivetrain.getEncoderRL() - startRearLeft) > -.25*distance)) Robot.drivetrain.autoDrive(-speed, 0, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderFL()- startFrontLeft) < .4*distance) && ((Robot.drivetrain.getEncoderRL() - startRearLeft) > -.5*distance)) Robot.drivetrain.autoDrive(-.75*speed, 0, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderFL()- startFrontLeft) < .7*distance) && ((Robot.drivetrain.getEncoderRL() - startRearLeft) > -.7*distance)) Robot.drivetrain.autoDrive(-.5*speed, 0, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderFL()- startFrontLeft) < .8*distance) && ((Robot.drivetrain.getEncoderRL() - startRearLeft) > -.9*distance)) Robot.drivetrain.autoDrive(-.33*speed, 0, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderFL()- startFrontLeft) < distance) && ((Robot.drivetrain.getEncoderRL() - startRearLeft) > -distance)) Robot.drivetrain.autoDrive(-.16*speed, 0, twistValue , 0);
	        else {                                                                                                                      
	            Robot.drivetrain.autoDrive(0, 0, 0, 0);
	            doneYet = true;
	        }
	    }
	    
	    if (state == 4){ //move backward
	    	
	    	SmartDashboard.putNumber("start rear left", startRearLeft);
	        SmartDashboard.putNumber("start rear right", startRearRight);     
	       
	        if (((Robot.drivetrain.getEncoderRL() - Robot.drivetrain.getEncoderRR()) > 5) &&
	                ((Robot.drivetrain.getEncoderRL() - Robot.drivetrain.getEncoderRR()) < 10)) twistValue = -0.05;
	        if (((Robot.drivetrain.getEncoderRR() - Robot.drivetrain.getEncoderRL()) > 5) &&
	                ((Robot.drivetrain.getEncoderRR() - Robot.drivetrain.getEncoderRL()) < 10)) twistValue = 0.05;
	        if (((Robot.drivetrain.getEncoderRL() - Robot.drivetrain.getEncoderRR()) > 10) &&
	                ((Robot.drivetrain.getEncoderRL() - Robot.drivetrain.getEncoderRR()) < 15)) twistValue = -0.1;
	        if (((Robot.drivetrain.getEncoderRR() - Robot.drivetrain.getEncoderRL()) > 10) &&
	                ((Robot.drivetrain.getEncoderRR() - Robot.drivetrain.getEncoderRL()) < 15)) twistValue = 0.1;
	        if (((Robot.drivetrain.getEncoderRL() - Robot.drivetrain.getEncoderRR()) > 15) &&
	                ((Robot.drivetrain.getEncoderRL() - Robot.drivetrain.getEncoderRR()) < 20)) twistValue = -0.15;
	        if (((Robot.drivetrain.getEncoderRR() - Robot.drivetrain.getEncoderRL()) > 15) &&
	                ((Robot.drivetrain.getEncoderRR() - Robot.drivetrain.getEncoderRL()) < 20)) twistValue = 0.15;
	        if (((Robot.drivetrain.getEncoderRL() - Robot.drivetrain.getEncoderRR()) > 20) &&
	                ((Robot.drivetrain.getEncoderRL() - Robot.drivetrain.getEncoderRR()) < 25)) twistValue = -0.2;
	        if (((Robot.drivetrain.getEncoderRR() - Robot.drivetrain.getEncoderRL()) > 20) &&
	                ((Robot.drivetrain.getEncoderRR() - Robot.drivetrain.getEncoderRL()) < 25)) twistValue = 0.2;
	        
	        
	        if (((Robot.drivetrain.getEncoderRL()- startRearLeft) < .25*distance) && ((Robot.drivetrain.getEncoderRR() - startRearRight) < .25*distance)) Robot.drivetrain.autoDrive(0, -speed, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderRL()- startRearLeft) < .4*distance) && ((Robot.drivetrain.getEncoderRR() - startRearRight) < .5*distance)) Robot.drivetrain.autoDrive(0, -.75*speed, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderRL()- startRearLeft) < .7*distance) && ((Robot.drivetrain.getEncoderRR() - startRearRight) < .7*distance)) Robot.drivetrain.autoDrive(0, -.5*speed, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderRL()- startRearLeft) < .8*distance) && ((Robot.drivetrain.getEncoderRR() - startRearRight) < .9*distance)) Robot.drivetrain.autoDrive(0, -.33*speed, twistValue , 0);
	        else if (((Robot.drivetrain.getEncoderRL()- startRearLeft) < distance) && ((Robot.drivetrain.getEncoderRR() - startRearRight) < distance)) Robot.drivetrain.autoDrive(0, -.16*speed, twistValue , 0);
	        else {                                                                                                                      
	            Robot.drivetrain.autoDrive(0, 0, 0, 0);
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
    	state = 0;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
