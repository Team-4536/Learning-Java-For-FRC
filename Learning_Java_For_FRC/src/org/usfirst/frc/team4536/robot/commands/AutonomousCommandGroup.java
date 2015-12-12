package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Sheila
 */
public class AutonomousCommandGroup extends CommandGroup {
    
    public  AutonomousCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	//NEGATIVE is UP, and POSITIVE is DOWN
    	addSequential(new ElevatorAutoCommand(3, 0.5)); //half speed down for 3 seconds
    	addParallel(new DriveForwardCommand(1)); //hopefully, moves forward for 1 second
    	addSequential(new ElevatorAutoCommand(3, -0.5)); //half speed up for 3 seconds

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
