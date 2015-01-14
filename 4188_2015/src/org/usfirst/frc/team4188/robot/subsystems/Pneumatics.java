package org.usfirst.frc.team4188.robot.subsystems;

import org.usfirst.frc.team4188.robot.RobotMap;
import org.usfirst.frc.team4188.robot.commands.PneumaticsDoNothing;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	private static final double PNEUMATIC_DELAY_SECONDS = 0.2;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Compressor compressor = RobotMap.Compressor;
	DoubleSolenoid solenoid1 = RobotMap.testSolenoid1;
	DoubleSolenoid solenoid2 = RobotMap.testSolenoid2;
	DoubleSolenoid solenoid3 = RobotMap.testSolenoid3;
	DoubleSolenoid solenoid4 = RobotMap.testSolenoid4;
	
	public void init(){
		compressor.start();
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new PneumaticsDoNothing());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setPneumatic1Forward(){
    	solenoid1.set(DoubleSolenoid.Value.kForward);     
        Timer.delay(PNEUMATIC_DELAY_SECONDS);
        solenoid1.set(DoubleSolenoid.Value.kOff);     
    }
    
    public void setPneumatic1Backward(){
    	solenoid1.set(DoubleSolenoid.Value.kReverse);     
        Timer.delay(PNEUMATIC_DELAY_SECONDS);
        solenoid1.set(DoubleSolenoid.Value.kOff);  
    }
    
    public void setPneumatic1Off(){
    	solenoid1.set(DoubleSolenoid.Value.kOff);  
    }
    
    public void setPneumatic2Forward(){
    	solenoid2.set(DoubleSolenoid.Value.kForward);     
        Timer.delay(PNEUMATIC_DELAY_SECONDS);
        solenoid2.set(DoubleSolenoid.Value.kOff);     
    }
    
    public void setPneumatic2Backward(){
    	solenoid2.set(DoubleSolenoid.Value.kReverse);     
        Timer.delay(PNEUMATIC_DELAY_SECONDS);
        solenoid2.set(DoubleSolenoid.Value.kOff);  
    }
    
    public void setPneumatic2Off(){
    	solenoid2.set(DoubleSolenoid.Value.kOff);  
    }
    
    public void setPneumatic3Forward(){
    	solenoid3.set(DoubleSolenoid.Value.kForward);     
        Timer.delay(PNEUMATIC_DELAY_SECONDS);
        solenoid3.set(DoubleSolenoid.Value.kOff);     
    }
    
    public void setPneumatic3Backward(){
    	solenoid3.set(DoubleSolenoid.Value.kReverse);     
        Timer.delay(PNEUMATIC_DELAY_SECONDS);
        solenoid3.set(DoubleSolenoid.Value.kOff);  
    }
    
    public void setPneumatic3Off(){
    	solenoid3.set(DoubleSolenoid.Value.kOff);  
    }
    
    public void setPneumatic4Forward(){
    	solenoid4.set(DoubleSolenoid.Value.kForward);     
        Timer.delay(PNEUMATIC_DELAY_SECONDS);
        solenoid4.set(DoubleSolenoid.Value.kOff);     
    }
    
    public void setPneumatic4Backward(){
    	solenoid4.set(DoubleSolenoid.Value.kReverse);     
        Timer.delay(PNEUMATIC_DELAY_SECONDS);
        solenoid4.set(DoubleSolenoid.Value.kOff);  
    }
    
    public void setPneumatic4Off(){
    	solenoid4.set(DoubleSolenoid.Value.kOff);  
    }
}

