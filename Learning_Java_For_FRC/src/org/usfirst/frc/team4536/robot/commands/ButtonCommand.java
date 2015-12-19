package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.RobotMap;

public class ButtonCommand extends CommandBase {
	
	
    public ButtonCommand() {
    
    }
	public static Joystick mainStick = new Joystick(RobotMap.MAIN_STICK);
	
	public static Button extendPiston;
	public static Button retractPiston;
			
	// Called just before this Command runs the first time
    protected void initialize() {
    	
    }
    	
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		extendPiston = new JoystickButton(mainStick, 3);
		retractPiston = new JoystickButton(mainStick, 4);
	
		extendPiston.whenPressed (new Piston_Extend());
		retractPiston.whenPressed (new Piston_Retract());	

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
