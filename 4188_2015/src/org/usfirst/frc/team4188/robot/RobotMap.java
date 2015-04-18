package org.usfirst.frc.team4188.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
	

	public static double canBurglarSpeed = 0.4;
	public static double circumference = 8 * Math.PI;	// Wheel size in inches
	public static double tickDistance = circumference / 360;
	
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
	public static CANTalon testMotor3;
	public static CANTalon testMotor4;
	
	public static Relay testRelay1;
	public static Relay testRelay2;
	public static Relay testRelay3;
	public static Relay testRelay4;
	
	public static DigitalInput limSwitch1;
	public static DigitalInput limSwitch2;
	public static DigitalInput limSwitch3;
	public static DigitalInput limSwitch4;
	public static DigitalInput limSwitch5;
	public static DigitalInput limSwitch6;
	public static DigitalInput limSwitch7;
	public static DigitalInput limSwitch8;
	
	public static AnalogInput potentiometer;
	
	public static void init() {
		exitAuto = false;
		
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
		
		frontLeft.ClearIaccum();
		
		driveBase = new CHSRobotDrive (frontLeft, rearLeft, frontRight, rearRight);
		driveBase.setSafetyEnabled(false);
		driveBase.setExpiration(0.1);
		driveBase.setSensitivity(0.5);
		driveBase.setMaxOutput(1.0);
		driveBase.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
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
		
	/**	encoder1 = new Encoder(0, 1, false, EncodingType.k4X);
		encoder1.setDistancePerPulse(1.0);
		encoder1.setPIDSourceParameter(PIDSourceParameter.kRate);
		encoder1.startLiveWindowMode();
		LiveWindow.addSensor("Drivetrain", "frontLeftEncoder", encoder1);
	        
		encoder2 = new Encoder(2, 3, true, EncodingType.k4X);
		encoder2.setDistancePerPulse(1.0);
		encoder2.setPIDSourceParameter(PIDSourceParameter.kRate);
		encoder2.reset();
		LiveWindow.addSensor("Drivetrain", "frontRightEncoder", encoder2);
	        
		encoder3 = new Encoder(4, 5, false, EncodingType.k4X);
		encoder3.setDistancePerPulse(1.0);
		encoder3.setPIDSourceParameter(PIDSourceParameter.kRate);
		encoder3.startLiveWindowMode();
		LiveWindow.addSensor("Drivetrain", "rearLeftEncoder", encoder3);
	        
		encoder4 = new Encoder(6, 7, true, EncodingType.k4X);
		encoder4.setDistancePerPulse(1.0);
		encoder4.setPIDSourceParameter(PIDSourceParameter.kRate);
		encoder4.startLiveWindowMode();
		LiveWindow.addSensor("Drivetrain", "rearRightRencoder", encoder4); **/
		
	}
}
