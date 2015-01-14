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
	
	public static RobotDrive driveBase;
	public static Talon frontLeft;
	public static Talon frontRight;
	public static Talon rearLeft;
	public static Talon rearRight;
	public static Gyro drivetraingyro;
	
	public static Talon testMotor1;
	public static Talon testMotor2;
	public static Talon testMotor3;
	public static Talon testMotor4;
	
	public static Relay testRelay1;
	public static Relay testRelay2;
	public static Relay testRelay3;
	public static Relay testRelay4;
	
	public static Compressor Compressor;
	public static DoubleSolenoid testSolenoid1;
	public static DoubleSolenoid testSolenoid2;
	public static DoubleSolenoid testSolenoid3;
	public static DoubleSolenoid testSolenoid4;
	
	public static void init() {
		
		drivetraingyro = new Gyro(0); //Analog
		
		frontLeft = new Talon(0); //PWM
		frontRight = new Talon(1);
		rearLeft = new Talon(2);
		rearRight = new Talon(3);
		
		driveBase = new RobotDrive (frontLeft, rearLeft, frontRight, rearRight);
		driveBase.setSafetyEnabled(false);
		driveBase.setExpiration(0.1);
		driveBase.setSensitivity(0.5);
		driveBase.setMaxOutput(1.0);
		driveBase.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		driveBase.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		
		testMotor1 = new Talon(4); //PWM
		testMotor2 = new Talon(5);
		testMotor3 = new Talon(6);
		testMotor4 = new Talon(7);
		
		testRelay1 = new Relay(0, Relay.Direction.kBoth); //Relay
		testRelay2 = new Relay(1, Relay.Direction.kBoth);
		testRelay3 = new Relay(2, Relay.Direction.kBoth);
		testRelay4 = new Relay(3, Relay.Direction.kBoth);
		
		Compressor = new Compressor(); //default PCM CAN ID
		testSolenoid1 = new DoubleSolenoid(0,1);
		testSolenoid2 = new DoubleSolenoid(2,3);
		testSolenoid3 = new DoubleSolenoid(4,5);
		testSolenoid4 = new DoubleSolenoid(6,7);
	}
}
