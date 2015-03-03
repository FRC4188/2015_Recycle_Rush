package org.usfirst.frc.team4188.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4188.robot.RobotMap;

/**
 *
 */
public class Motors extends Subsystem {
	
	CANTalon motor1 = RobotMap.testMotor1; //lift
	CANTalon motor2 = RobotMap.testMotor2; //claw
	CANTalon motor3 = RobotMap.testMotor3;
	CANTalon motor4 = RobotMap.testMotor4;
	
	DigitalInput lim1 = RobotMap.limSwitch1;
	DigitalInput lim2 = RobotMap.limSwitch2;
	DigitalInput lim3 = RobotMap.limSwitch3;
	DigitalInput lim4 = RobotMap.limSwitch4;
	DigitalInput lim5 = RobotMap.limSwitch5;
	DigitalInput lim6 = RobotMap.limSwitch6;
	DigitalInput lim7 = RobotMap.limSwitch7;
	DigitalInput lim8 = RobotMap.limSwitch8;
    
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
    
    public boolean isLim1Hit (){ //front hit
    	return lim1.get();
    }

    public boolean isLim2Hit (){ //close claw hit
    	return lim2.get();
    }
    
    public boolean isLim3Hit (){ //open claw hit
    	return lim3.get();
    }

    public boolean isLim4Hit (){
    	return lim4.get();
    }
    
    public boolean isLim5Hit (){
    	return lim5.get();
    }
    
    public boolean isLim6Hit (){
    	return lim6.get();
    }
    
    public boolean isLim7Hit (){
    	return lim7.get();
    }
    
    public boolean isLim8Hit (){
    	return lim8.get();
    }
    
    public void stopMotor1(){
    	motor1.set(0);
    }

    public void stopMotor2(){
    	motor2.set(0);
    }

    public void stopMotor3(){
    	motor3.set(0);
    }
    
    public double getMotor1(){
    	return motor1.get();
    }

    public void stopMotor4(){
    	motor4.set(0);
    }
    
    public void runMotor1(double e){
    	motor1.set(e);
    }
    
    public void runMotor2(double e){
    	motor2.set(e);
    }
    
    public void runMotor3(double e){
    	motor3.set(e);
    }
    
    public void runMotor4(double e){
    	motor4.set(e);
    }
    
    public double getEncoderClaw(){
		return motor2.getEncPosition();
	}
}

