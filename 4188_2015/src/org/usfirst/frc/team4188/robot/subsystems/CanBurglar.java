package org.usfirst.frc.team4188.robot.subsystems;

import org.usfirst.frc.team4188.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CanBurglar extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon CanBurglarMotor = RobotMap.canBurglar;	
	
	public void init(){
		
	}
	public boolean isAtTop (){
		// Return true if upper switch is pressed
		return CanBurglarMotor.isFwdLimitSwitchClosed();
	}
	public boolean isAtBottom (){
		// Return true if lower switch is pressed 
		return CanBurglarMotor.isRevLimitSwitchClosed();
	}
	
	public void goUp(double speed){
		CanBurglarMotor.set(Math.abs(speed));
	}

	public void goDown(double speed){
		CanBurglarMotor.set(-Math.abs(speed));
	}
	
    public void initDefaultCommand() {
		CanBurglarMotor.set(0.0);
    }
}

