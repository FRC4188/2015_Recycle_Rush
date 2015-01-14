package org.usfirst.frc.team4188.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4188.*;
import org.usfirst.frc.team4188.robot.RobotMap;

/**
 *
 */
public class Motors extends Subsystem {
	
	Talon motor1 = RobotMap.testMotor1;
	Talon motor2 = RobotMap.testMotor2;
	Talon motor3 = RobotMap.testMotor3;
	Talon motor4 = RobotMap.testMotor4;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void init(){
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void runMotor1WithJoystick(double y){
    	motor1.set(y);
    }
    
    public void runMotor2WithJoystick(double y){
    	motor2.set(y);
    }
    
    public void runMotor3WithJoystick(double y){
    	motor3.set(y);
    }
    
    public void runMotor4WithJoystick(double y){
    	motor4.set(y);
    }
}

