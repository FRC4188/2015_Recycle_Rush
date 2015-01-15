package org.usfirst.frc.team4188.robot.subsystems;

import org.usfirst.frc.team4188.robot.RobotMap;
import org.usfirst.frc.team4188.robot.commands.RelaysDoNothing;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Relays extends Subsystem {
    
	Relay relay1 = RobotMap.testRelay1;
	Relay relay2 = RobotMap.testRelay2;
	Relay relay3 = RobotMap.testRelay3;
	Relay relay4 = RobotMap.testRelay4;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void init(){
		relay1.set(Relay.Value.kOff);
		relay2.set(Relay.Value.kOff);
		relay3.set(Relay.Value.kOff);
		relay4.set(Relay.Value.kOff);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new RelaysDoNothing());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void runRelay1Forward(){
//    	relay1.set(Relay.Value.kOn);
    	relay1.set(Relay.Value.kForward);
    }
    
    public void runRelay1Backward(){
//    	relay1.set(Relay.Value.kOn);
    	relay1.set(Relay.Value.kReverse);
    }
    
    public void stopRelay1(){
    	relay1.set(Relay.Value.kOff);
    }
    
    public void runRelay2Forward(){
//    	relay2.set(Relay.Value.kOn);
    	relay2.set(Relay.Value.kForward);
    }
    
    public void runRelay2Backward(){
//    	relay2.set(Relay.Value.kOn);
    	relay2.set(Relay.Value.kReverse);
    }
    
    public void stopRelay2(){
    	relay2.set(Relay.Value.kOff);
    }
    
    public void runRelay3Forward(){
//    	relay3.set(Relay.Value.kOn);
    	relay3.set(Relay.Value.kForward);
    }
    
    public void runRelay3Backward(){
//    	relay3.set(Relay.Value.kOn);
    	relay3.set(Relay.Value.kReverse);
    }
    
    public void stopRelay3(){
    	relay3.set(Relay.Value.kOff);
    }
    
    public void runRelay4Forward(){
//    	relay4.set(Relay.Value.kOn);
    	relay4.set(Relay.Value.kForward);
    }
    
    public void runRelay4Backward(){
//    	relay4.set(Relay.Value.kOn);
    	relay4.set(Relay.Value.kReverse);
    }
    
    public void stopRelay4(){
    	relay4.set(Relay.Value.kOff);
    }
}

