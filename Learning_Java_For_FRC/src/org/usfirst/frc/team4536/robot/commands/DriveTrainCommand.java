package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.*;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team4536.robot.Constants;

/**
 * 
 */
public class DriveTrainCommand extends CommandBase {
	
	double prevForwardThrottle = 0;
	double prevTurnThrottle = 0;
	Encoder encoder = new Encoder(2, 7); 
	//TODO if encoder is broken, switch these params

	
    public DriveTrainCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Scale: "+encoder.getEncodingScale());
		//encoder.setDistancePerPulse(Constants.PULSE_DISTANCE);
    	driveTrain.arcadeDrive(0, 0);
    }

    // Default drive command
    protected void execute() {
    	System.out.println("e: "+encoder.get());
    	double forwardThrottle = OI.mainStick.getY();
    	double turnThrottle = OI.mainStick.getX();
    	
    	forwardThrottle = Utilities.deadZone(forwardThrottle, Constants.DEAD_ZONE);
    	turnThrottle = Utilities.deadZone(turnThrottle, Constants.DEAD_ZONE);
    	
    	forwardThrottle = Utilities.limit(forwardThrottle, Constants.LIMIT);
    	turnThrottle = Utilities.limit(turnThrottle, Constants.LIMIT);
    	
    	forwardThrottle = Utilities.speedCurve(forwardThrottle, Constants.SPEED_CURVE);
    	turnThrottle = Utilities.speedCurve(turnThrottle, Constants.SPEED_CURVE);
    	
    	forwardThrottle = Utilities.accelLimit(forwardThrottle, prevForwardThrottle, Constants.ACCEL_LIMIT);
    	turnThrottle = Utilities.accelLimit(turnThrottle, prevTurnThrottle, Constants.ACCEL_LIMIT);
    			
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
