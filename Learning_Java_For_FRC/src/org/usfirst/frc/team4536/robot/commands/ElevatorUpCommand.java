package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

import org.usfirst.frc.team4536.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 * 
 */
public class ElevatorUpCommand extends CommandBase {
	Timer timer = new Timer();
	
    public ElevatorUpCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevator.drive(0.0);
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(timer.get());
    	elevator.drive(-0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (timer.get() > 500000) {
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
