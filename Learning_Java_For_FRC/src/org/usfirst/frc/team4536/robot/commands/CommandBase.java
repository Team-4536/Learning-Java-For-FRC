
package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 *
 */

public abstract class CommandBase extends Command {
	
	/*public static PIDDriveTrain driveTrain = new PIDDriveTrain(RobotMap.LEFT_MOTOR, RobotMap.RIGHT_MOTOR, RobotMap.GYRO);
	public static CompressorSubsystem compSub = new CompressorSubsystem();
	public static Elevator elevator = new Elevator(RobotMap.ELEVATOR_MOTOR,
			RobotMap.ELEVATOR_ENCODER_A_CHANNEL,
			RobotMap.ELEVATOR_ENCODER_B_CHANNEL,
			RobotMap.TOP_LIMIT_SWITCH,
			RobotMap.MIDDLE_LIMIT_SWITCH,
			RobotMap.BOTTOM_LIMIT_SWITCH);
	public static Platform platform = new Platform(RobotMap.LEFT_PLATFORM_SOLENOID_CHANNEL,
												   RobotMap.RIGHT_PLATFORM_SOLENOID_CHANNEL);
	public static Canburgler canburgler = new Canburgler(RobotMap.CANBURGLER_LEFT_SOLENOID_CHANNEL, 
														 RobotMap.CANBURGLER_RIGHT_SOLENOID_CHANNEL);
*/
	Elevator elevator = new Elevator(2);
	
    public CommandBase() {
        // Use requires() here to declare subsystem dependencies
     //eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
