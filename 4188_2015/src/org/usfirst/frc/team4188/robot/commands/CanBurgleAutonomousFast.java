package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class CanBurgleAutonomousFast extends CommandGroup {
    
    public  CanBurgleAutonomousFast() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
    	// arm.

    	addSequential (new CanBurglarDown(0.55, 0.6));	// Move arm down for x seconds at y speed
    	Timer.delay(0.1);								// Pause thread for x seconds
    	addSequential (new CanBurglarUp(0.6));			// Move up for 1 second(s)

    	addParallel (new CanBurglarStayUp());			// Hold arm up while driving and until end of autonomous
    	Robot.drivetrain.resetEncoders();				// Zero the encoders then move straight ahead at 60%
    	addSequential (new AutoDriveBearingForDistance(0.6, 0.0, 0.0, 60.0));
    }
}