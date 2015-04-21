package org.usfirst.frc.team4188.robot;

import edu.wpi.first.wpilibj.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static final double CANBURGLARSPEED = 0.6;

	// 8" wheels * pi = 25.132
	// 360 ticks/revolution * 2 edges * 2 channels (a + b) = 1440
	// 1440/25.132 = 57.3
	// mechanum 20% loss * 57.3 = 45 
	public static final double TICKSPERINCH = 45;				// Ticks/inch for 8 inch mechanum wheels
	
	public static boolean exitAuto;
	
	public static CHSRobotDrive driveBase;
	public static CANTalon frontLeft;
	public static CANTalon frontRight;
	public static CANTalon rearLeft;
	public static CANTalon rearRight;
	public static Gyro drivetraingyro;
	
	public static CANTalon canBurglar;
	
	public static CANTalon liftMotor;
	public static CANTalon clawMotor;
	
	public static AnalogInput potentiometer;
	
	public static void init() {
		
	drivetraingyro = new Gyro(0); 			//Analog Input
	drivetraingyro.setSensitivity(0.007);
	
	frontLeft = new CANTalon(11); 
	frontRight = new CANTalon(12);
	rearLeft = new CANTalon(13);
	rearRight = new CANTalon(14);

	frontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	frontRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	rearLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	rearRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
//	frontRight.reverseOutput(true);
//	rearRight.reverseOutput(true);
		
	frontLeft.ClearIaccum();
	
	driveBase = new CHSRobotDrive (frontLeft, rearLeft, frontRight, rearRight);
	driveBase.setSafetyEnabled(false);
	driveBase.setExpiration(0.1);
	driveBase.setSensitivity(0.5);
	driveBase.setMaxOutput(1.0);
	driveBase.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);		// Reverse with CANTalons to have sensors in sync
	driveBase.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);		
	
	liftMotor = new CANTalon(15);
	liftMotor.enableLimitSwitch(true, true);
	liftMotor.ConfigFwdLimitSwitchNormallyOpen(true);
	liftMotor.ConfigRevLimitSwitchNormallyOpen(true);

	clawMotor = new CANTalon(16);
	clawMotor.enableLimitSwitch(true, true);
	clawMotor.ConfigFwdLimitSwitchNormallyOpen(true);
	clawMotor.ConfigRevLimitSwitchNormallyOpen(true);
	clawMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder); //magnetic encoder

	canBurglar = new CANTalon(17);
	canBurglar.enableLimitSwitch(true, true);
	canBurglar.ConfigFwdLimitSwitchNormallyOpen(true);
	canBurglar.ConfigRevLimitSwitchNormallyOpen(true);
	}
}
