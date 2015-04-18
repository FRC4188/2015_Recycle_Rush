
package org.usfirst.frc.team4188.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4188.robot.commands.Autonomous;
import org.usfirst.frc.team4188.robot.commands.CanBurgleAutonomous;
import org.usfirst.frc.team4188.robot.commands.GoForwardAutonomous;
import org.usfirst.frc.team4188.robot.commands.GoForwardWithToteAutonomous;
import org.usfirst.frc.team4188.robot.commands.GoRightGoForwardAutonomous;
import org.usfirst.frc.team4188.robot.commands.Relay1Forward;
import org.usfirst.frc.team4188.robot.commands.SensorDisplay;
import org.usfirst.frc.team4188.robot.subsystems.CanBurglar;
import org.usfirst.frc.team4188.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4188.robot.subsystems.Motors;
import org.usfirst.frc.team4188.robot.subsystems.Relays;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {


    Command autonomousCommand;
    SendableChooser autoChooser;
    Command sensors;
    
	
	public static DriveTrain drivetrain;
	public static OI oi;
	public static Motors motors;
	public static Relays relays;
	public static CanBurglar canBurglar;


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();
		oi = new OI();
		drivetrain = new DriveTrain();
		motors = new Motors();
//		relays = new Relays();
		canBurglar = new CanBurglar();
		autoChooser = new SendableChooser();
		
		motors.init();
	    drivetrain.init();
//	    relays.init();
	    canBurglar.init();
	    
        autonomousCommand = new Autonomous();
        sensors = new SensorDisplay();
        
        
        autoChooser.addDefault("Pick up Garbage Can and Move Forward", new GoForwardAutonomous() );
        autoChooser.addDefault("Pick up Garbage Can and Move Forward With Tote", new GoRightGoForwardAutonomous() );
        autoChooser.addDefault("Pick up Tote and Move Forward", new GoForwardWithToteAutonomous() );
        autoChooser.addDefault("Can Burglar", new CanBurgleAutonomous());
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        
       
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autoChooser.getSelected();
    	autonomousCommand.start();
    	sensors.start();
        if (autonomousCommand != null) autonomousCommand.start();
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        sensors.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
