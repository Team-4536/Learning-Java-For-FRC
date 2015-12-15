package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

import edu.wpi.first.wpilibj.Timer;
/**
 * @author Sheila (newbie)
 */
public class DriveAutoCommand extends TimeOutCommandBase {

	Timer timer = new Timer();
	double speed;
	double turn;
	
    public DriveAutoCommand(double timeOut, double spd, double trn) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super(timeOut);
    	speed = spd;
    	turn = trn;
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.arcadeDrive(0.0, 0.0);
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Time running: " + timer.get());
    	//first var is forward/backward, second var is turning
    	//forwards is negative (same as up in elevator)
    	driveTrain.arcadeDrive(speed,turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (timer.get() > 2) {
    		return true;
    	}
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
