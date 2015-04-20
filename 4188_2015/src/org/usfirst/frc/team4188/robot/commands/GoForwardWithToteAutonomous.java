package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GoForwardWithToteAutonomous extends CommandGroup {
    
    public  GoForwardWithToteAutonomous() {
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
   
    	addSequential(new LiftUp (3.0));

	    Robot.drivetrain.resetEncoders();
		addSequential (new AutoDriveBearingForDistance(0.6, 0.0, 0.0, 108.0));    	
    	addSequential (new CanBurglarStayUp());
    }
}
