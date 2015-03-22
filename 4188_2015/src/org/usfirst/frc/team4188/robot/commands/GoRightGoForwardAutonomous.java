package org.usfirst.frc.team4188.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GoRightGoForwardAutonomous extends CommandGroup {
    
    public  GoRightGoForwardAutonomous() {
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
    	
    	addSequential(new GarbageCanLift ());
    	addSequential(new AutomaticGrab());//can we change how much it lifts here? or create two separate classes that close the claw and then move up for GBGCan
    	addSequential(new AutoDrive(200, -0.8, 2)); //move right till in front of the yellow tote.
    	addSequential(new AutoDrive(6500, -0.8, 1)); //move forward till inside the zone
    }
}
