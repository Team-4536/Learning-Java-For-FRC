package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4536.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;

public class OI {

	public static Joystick mainStick = new Joystick(RobotMap.MAIN_STICK);
	
	public static Button extendPiston;
	public static Button retractPiston;
			
	public OI() {
		
		extendPiston = new JoystickButton(mainStick, 3);
		retractPiston = new JoystickButton(mainStick, 4);
	
		extendPiston.whenPressed (new Piston_Extend());
		retractPiston.whenPressed (new Piston_Retract());	
	}
}
	
