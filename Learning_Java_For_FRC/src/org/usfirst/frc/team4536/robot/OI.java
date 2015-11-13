package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team4536.robot.commands.*;
import org.usfirst.frc.team4536.robot.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick mainStick;
	public static Joystick secondaryStick;
	
	public static Button platformToggleButton;
	public static Button canburglerToggleButton;
	public static Button driveElevatorWithStickButton;
	public static Button elevatorToHeight50Button;
	
	public static Button turnToGroup30;
	public static Button turnToGroup0;
	
	public OI() {
		//----------------initializations------------------
		mainStick = new Joystick(RobotMap.MAIN_STICK);
		secondaryStick = new Joystick(RobotMap.SECONDARY_STICK);
		
		platformToggleButton = new JoystickButton(mainStick, 2);
		canburglerToggleButton = new JoystickButton(mainStick, 3);


		//TODO set joystick y input to the elevator command
		
		Button goToBottomOfFeederStationButton = new JoystickButton(secondaryStick, 2);
		Button goToTopOfFeederStationButton = new JoystickButton(secondaryStick, 3);
		Button goToScoringPlatformButton = new JoystickButton(secondaryStick, 4);
		Button goToRecyclingContainerButton = new JoystickButton(secondaryStick, 5);
		Button elevatorManualOverrideButton = new JoystickButton(secondaryStick, 6);
		Button a = new JoystickButton(secondaryStick, 7);
		
		//-------------------actions------------------

		/*platformToggleButton.whenPressed(new TogglePlatform());
		
		canburglerToggleButton.whenPressed(new ToggleCanburgler());
		
		goToBottomOfFeederStationButton.whenPressed(new GoToHeightAndHold(Constants.HEIGHT_FOR_BOTTOM_OF_FEEDER_STATION, 1));
		goToTopOfFeederStationButton.whenPressed(new GoToHeightAndHold(Constants.HEIGHT_FOR_TOP_OF_FEEDER_STATION, 1));
		goToScoringPlatformButton.whenPressed(new GoToHeightAndHold(Constants.HEIGHT_FOR_SCORING_PLATFORM, .25));
		goToRecyclingContainerButton.whenPressed(new GoToHeightAndHold(Constants.HEIGHT_FOR_RECYCLING_CONTAINER, 1));
		elevatorManualOverrideButton.whileHeld(new DriveElevatorWithStick());
		elevatorManualOverrideButton.whenReleased(new HoldElevator());*/

	}
	

	
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

