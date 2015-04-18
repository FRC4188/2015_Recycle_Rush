package org.usfirst.frc.team4188.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4188.robot.RobotMap;

/**
 *
 */
public class Motors extends Subsystem {
	
	CANTalon liftMotor = RobotMap.liftMotor;
	CANTalon clawMotor = RobotMap.clawMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void init(){
		//motor2.clearStickyFaults();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void runLiftWithJoystick(double y){ //lift
    	liftMotor.set(y);
    }
    
    public void runClawWithJoystick(double y){ //claw
    	clawMotor.set(y);
    }
    
//    public boolean isLim1Hit (){ //front hit
//    	return lim1.get();
//    }

	public boolean isClawClosed (){ //close claw hit
		return clawMotor.isFwdLimitSwitchClosed();
	}
    
    public boolean isClawOpen (){ //open claw hardwired
    	return clawMotor.isRevLimitSwitchClosed();
    }

    public boolean isLiftTop (){ //top hardwired
    	return liftMotor.isFwdLimitSwitchClosed();
    }
    
    public boolean isLiftBottom (){ //bottom hardwired
    	return liftMotor.isRevLimitSwitchClosed();
    }
    
//    public boolean isLim6Hit (){ //close claw hardwired
//    	return lim6.get();
//    }
        
    public void stopLift(){
    	liftMotor.set(0);
    }

    public void stopClaw(){
    	clawMotor.set(0);
    }

    public double getLift(){
    	return liftMotor.get();
    }

    public void liftDown(double speed){	// Positive is Down
		liftMotor.set(Math.abs(speed));
    }
    
    public void liftUp(double speed){	// Negative is Up
		liftMotor.set(-Math.abs(speed));
    }
    
    public void runLift(double e){
    	liftMotor.set(e);
    }
    
    public void runClaw(double e){
    	clawMotor.set(e);
    }
    
    public double getEncoderClaw(){
		return clawMotor.getEncPosition();
	}
    
    public boolean getClawCloseLim(){    	//motor2.get();
    	return clawMotor.isFwdLimitSwitchClosed();
    }
    
    public boolean getClawOpenLim(){
    	return clawMotor.isRevLimitSwitchClosed();
    }
    
    public boolean getLiftBottomLim(){
    	return liftMotor.isFwdLimitSwitchClosed();
    }
    
    public boolean getLiftTopLim(){
    	return liftMotor.isRevLimitSwitchClosed();
    }
    
}

