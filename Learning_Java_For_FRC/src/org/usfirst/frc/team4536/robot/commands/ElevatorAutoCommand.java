package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

import edu.wpi.first.wpilibj.Timer;

/**
 * @author Sheila (newbie)
 */
public class ElevatorAutoCommand extends TimeOutCommandBase {
	
	Timer timer = new Timer();
	double speed;

    public ElevatorAutoCommand(double timeOut, double spd) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super(timeOut);
    	//NEGATIVE is UP, and POSITIVE is DOWN
    	speed = spd;
    	requires(elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Initializing elevatorAutoCommand...");
    	elevator.drive(0.0);
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Time running: " + timer.get());
    	//NEGATIVE is UP
    	elevator.drive(speed);
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
    	elevator.drive(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
