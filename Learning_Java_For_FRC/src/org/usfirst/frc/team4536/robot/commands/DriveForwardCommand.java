package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

import org.usfirst.frc.team4536.robot.commands.CommandBase;
//TODO fix this drive forward class
/**
 * 
 */
public class DriveForwardCommand extends CommandBase {
	
	private double speed;
	
	public void start(double spd) {
		speed = spd;
		start();
	}
	
	
    public DriveForwardCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.arcadeDrive(0.0, 0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.arcadeDrive(0-speed, 0-speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
