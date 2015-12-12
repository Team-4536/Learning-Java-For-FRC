package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Sheila (newbie)
 */
public class AutonomousCommandGroup extends CommandGroup {
    
    public  AutonomousCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	//NEGATIVE is UP   or FORWARD  or LEFT, and
    	//POSITIVE is DOWN or BACKWARD or RIGHT
    	//drive 1 second, forward quarter speed, no turn
    	addParallel(new DriveAutoCommand(1, -0.25, 0.0)); 
    	//elevator 3 seconds, down half speed
    	addSequential(new ElevatorAutoCommand(3, 0.5)); 
    	//elevator 3 seconds, up half speed
    	addSequential(new ElevatorAutoCommand(3, -0.5)); 

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
    }
}
