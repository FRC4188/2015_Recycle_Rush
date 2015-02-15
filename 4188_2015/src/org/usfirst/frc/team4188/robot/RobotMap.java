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
	
	public static RobotDrive driveBase;
	public static CANTalon frontLeft;
	public static CANTalon frontRight;
	public static CANTalon rearLeft;
	public static CANTalon rearRight;
	public static Gyro drivetraingyro;
	
	public static CANTalon testMotor1;
	public static CANTalon testMotor2;
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
	
	public static AnalogInput potentiometer;
	
	public static void init() {
		
		drivetraingyro = new Gyro(0); //Analog
		drivetraingyro.setSensitivity(0.007);
		
		frontLeft = new CANTalon(11); 
		frontRight = new CANTalon(12);
		rearLeft = new CANTalon(13);
		rearRight = new CANTalon(14);
		
		frontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		frontRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		rearLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		rearRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		
		driveBase = new RobotDrive (frontLeft, rearLeft, frontRight, rearRight);
		driveBase.setSafetyEnabled(false);
		driveBase.setExpiration(0.1);
		driveBase.setSensitivity(0.5);
		driveBase.setMaxOutput(1.0);
		driveBase.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		driveBase.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		
		testMotor1 = new CANTalon(15); //PWM //lift motor1
		testMotor2 = new CANTalon(16);
		testMotor3 = new CANTalon(17); //lift motor2
		testMotor4 = new CANTalon(18);
		
		testRelay1 = new Relay(0, Relay.Direction.kBoth); //Relay
		testRelay2 = new Relay(1, Relay.Direction.kBoth);
		testRelay3 = new Relay(2, Relay.Direction.kBoth);
		testRelay4 = new Relay(3, Relay.Direction.kBoth);

		limSwitch1 = new DigitalInput(0); //DIO
		limSwitch2 = new DigitalInput(1); //DIO
		limSwitch3 = new DigitalInput(2); //DIO
		limSwitch4 = new DigitalInput(3); //DIO
		limSwitch5 = new DigitalInput(4); //DIO
		limSwitch6 = new DigitalInput(5); //DIO
		
	//	potentiometer = new AnalogInput(1); //AIO
		
		
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
