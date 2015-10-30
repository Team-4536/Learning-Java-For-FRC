package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * moves elevator up (at half speed) until top limit switch
 */
public class ElevatorUpCommand extends CommandBase {

    public ElevatorUpCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//moves at half speed
    	elevator.drive(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return elevator.topLimitSwitchValue();
        
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	System.out.println("The elevator up command has stopped.");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
