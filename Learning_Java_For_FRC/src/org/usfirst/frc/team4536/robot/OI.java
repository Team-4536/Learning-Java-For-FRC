/**
 * These are what are called "imports" and they
 * are basically a way for us to use code that 
 * other programmers have already made.
 * In this case we are using the code made to
 * interface with joysticks made by another programmer.
 * We can use this code to collect axis values from the
 * joystick and drive the robot with it.
 */

package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4536.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;


/**
 * This class is where the magic happens. It's where you handle the controller that you're using to drive your robot!
 * "public" means that stuff can be accessed from other classes. Classes for non-programmers, I like to think of like sections.
 */
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
	
