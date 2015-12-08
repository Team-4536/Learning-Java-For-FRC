package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.commands.CommandBase;

/**
 * 
 */
public class ElevatorCommand extends CommandBase {
	
	double prevElevatorThrottle = 0;
	
    public ElevatorCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevator.drive(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double elevatorThrottle = OI.secondStick.getY();
    	
    	elevatorThrottle = Utilities.deadZone(elevatorThrottle, 0.1);
    	elevatorThrottle = Utilities.limit(elevatorThrottle, 1.0);
    	elevatorThrottle = Utilities.speedCurve(elevatorThrottle, 2.5);
    	elevatorThrottle = Utilities.accelLimit(elevatorThrottle, prevElevatorThrottle, 2);
    	
    	elevator.drive(elevatorThrottle);
    	
    	prevElevatorThrottle = elevatorThrottle;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevator.drive(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
