package org.usfirst.frc.team4188.robot;

import org.usfirst.frc.team4188.robot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	//joysticks and joystick buttons
	
	public JoystickButton pilot1;
	public JoystickButton pilot2;
	public JoystickButton pilot3;
	public JoystickButton pilot4;
	public JoystickButton pilot5;
	public JoystickButton pilot6;
	public JoystickButton pilot7;
	public JoystickButton pilot8;
	public JoystickButton pilot9;
	public JoystickButton pilot10;
	public JoystickButton pilot11;
	public JoystickButton pilot12;
    
    public JoystickButton copilot1;
    public JoystickButton copilot2;
    public JoystickButton copilot3;
    public JoystickButton copilot4;
    public JoystickButton copilot5;
    public JoystickButton copilot6;
    public JoystickButton copilot7;
    public JoystickButton copilot8;
    public JoystickButton copilot9;
    public JoystickButton copilot10;
    public JoystickButton copilot11;
    
    public CHSJoystick pilotJoystick;
    public CHSJoystick copilotJoystick;
    
    //Smart Dashboard buttons
    
//    InternalButton button1;
//    InternalButton button2;
    
    public OI() {
    	//joysticks and joystick buttons
    	pilotJoystick = new CHSJoystick(0,4,12,-12.0,12.0,1,1.0,-12.0,12.0,1,1.0,-12.0,12.0,1,1.0);
        copilotJoystick = new CHSJoystick(1,3,11,-5,5,1,1,-12.0,12.0,1,1.0,-12.0,12.0,1,1.0);
	
        pilot1 = new JoystickButton(pilotJoystick, 1);
        pilot2 = new JoystickButton(pilotJoystick, 2);
        pilot3 = new JoystickButton(pilotJoystick, 3);
        pilot4 = new JoystickButton(pilotJoystick, 4);
        pilot5 = new JoystickButton(pilotJoystick, 5);
        pilot6 = new JoystickButton(pilotJoystick, 6);
        pilot7 = new JoystickButton(pilotJoystick, 7);
        pilot8 = new JoystickButton(pilotJoystick, 8);
        pilot9 = new JoystickButton(pilotJoystick, 9);
        pilot10 = new JoystickButton(pilotJoystick, 10);
        pilot11 = new JoystickButton(pilotJoystick, 11);
        pilot12 = new JoystickButton(pilotJoystick, 12);
        
        copilot1 = new JoystickButton(copilotJoystick, 1);
        copilot2 = new JoystickButton(copilotJoystick, 2);
        copilot3 = new JoystickButton(copilotJoystick, 3);
        copilot4 = new JoystickButton(copilotJoystick, 4);
        copilot5 = new JoystickButton(copilotJoystick, 5);
        copilot6 = new JoystickButton(copilotJoystick, 6);
        copilot7 = new JoystickButton(copilotJoystick, 7);
        copilot8 = new JoystickButton(copilotJoystick, 8);
        copilot9 = new JoystickButton(copilotJoystick, 9);
        copilot10 = new JoystickButton(copilotJoystick, 10);
        copilot11 = new JoystickButton(copilotJoystick, 11);
        
        copilot2.whileHeld(new RunLiftMotor());
        copilot2.whenReleased(new StopLiftMotor());
        copilot3.whileHeld(new RunClawMotor());
        copilot3.whenReleased(new StopClawMotor());
      //  copilot4.whileHeld(new RunMotor3());
     //   copilot5.whileHeld(new RunMotor4());
        
      //  copilot4.whenPressed(new GoToSweetSpot());
      //  copilot5.whenPressed(new AutomaticStack());
        copilot7.whenPressed(new ResetClawLift());
        copilot10.whenPressed(new GoToSweetSpot());
        
        
//        pilot3.whileHeld(new RunLiftMotor());
//        pilot3.whenReleased(new StopLiftMotor());
//        pilot5.whileHeld(new RunClawMotor());
//        pilot5.whenReleased(new StopClawMotor());
        pilot11.whileHeld(new CanBurglarDown());
        pilot11.whenReleased(new CanBurglarStop());
        pilot12.whileHeld(new CanBurglarUp());
        pilot12.whenReleased(new CanBurglarStop());
        
        
//        //SmartDashboard buttons
//        button1 = new InternalButton();
//        SmartDashboard.putData("Autonomous Drive Forward", button1);
//        button1.whenPressed(new AutonomousSet(1));
//        
//        button2 = new InternalButton();
//        SmartDashboard.putData("Autonomous Garbage Can + Tote Forward", button2);
//        button2.whenPressed(new AutonomousSet(2));
    }
    
    public Joystick getpilotJoystick() {
        return pilotJoystick;
    }
    
    public Joystick getcopilotJoystick() {
        return copilotJoystick;
    }
}
