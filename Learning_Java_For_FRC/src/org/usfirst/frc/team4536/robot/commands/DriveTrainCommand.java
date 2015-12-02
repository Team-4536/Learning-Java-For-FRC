package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTrainCommand extends CommandBase {
	
	double prevForwardThrottle = 0;
	double prevTurnThrottle = 0;

	
    public DriveTrainCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.arcadeDrive(0, 0);
    }

    // Default drive command
    protected void execute() {
    	System.out.println(Utilities.accelLimit(0.1, 0, 0.04));
    	
    	double forwardThrottle = OI.mainStick.getY();
    	double turnThrottle = OI.mainStick.getX();
    	
    	forwardThrottle = Utilities.limit(forwardThrottle, 1.0);
    	turnThrottle = Utilities.limit(turnThrottle, 1.0);
    	
    	forwardThrottle = Utilities.speedCurve(forwardThrottle, 2.5);
    	turnThrottle = Utilities.speedCurve(turnThrottle, 2.5);
    	
    	forwardThrottle = Utilities.accelLimit(forwardThrottle, prevForwardThrottle, 2);
    	turnThrottle = Utilities.accelLimit(turnThrottle, prevTurnThrottle, 2);
    			
    	driveTrain.arcadeDrive(forwardThrottle, turnThrottle);
    	
    	prevForwardThrottle = forwardThrottle;
    	prevTurnThrottle = turnThrottle;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
