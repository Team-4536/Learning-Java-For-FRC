/**
 * @author Liam
 * These lines below are what we call imports. Imports are
 * a way for us to import code made by other people so that
 * we can use it. We are importing a bunch of code here to 
 * take care of the base code of running a robot such as 
 * collection data from robot systems and interfacing with joysticks!
 */
package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team4536.robot.subsystems.*;

/**
 * @author Liam
 
 */
public class Robot extends IterativeRobot {
	

	DriveTrain driveTrain = new DriveTrain(RobotMap.LEFT_MOTOR, RobotMap.RIGHT_MOTOR);
	
	boolean previousButtonState = false;
	
	boolean currentButtonState = false; 
	
	double psi = 110; 
	
	double driveControl = 1;

	public static Button mainControl;
	public static Button slowControl;
	public static Button exponentialControl;
	

	
	Joystick mainstick = new Joystick(1);
	Joystick ada = new Joystick(0);
	

	DriveTrain drivetrain = new DriveTrain(1,0);
	
	

	Elevator elevator = new Elevator(RobotMap.ELEVATOR_MOTOR,
							RobotMap.ELEVATOR_ENCODER_A_CHANNEL,
							RobotMap.ELEVATOR_ENCODER_B_CHANNEL,
							RobotMap.TOP_LIMIT_SWITCH,
							RobotMap.MIDDLE_LIMIT_SWITCH,
							RobotMap.BOTTOM_LIMIT_SWITCH);



	
	Platform platform1 = new Platform (3,2);
	Compressor compressor = new Compressor ();

	mainstick getRawButton(1);
	
    public void robotInit() {
    	
    }
	
	mainControl = new JoystickButton(maisStick, 3);
	slowControl = new JoystickButton(mainstick, 2);
	exponetionalControl = new JoystickButton(mainstick, 5);
   
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


    public void autonomousInit() {
    	
    }

   
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

 
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	platform1.retract();
    }

   
    public void disabledInit(){

    }


   

    public void teleopPeriodic() {
        // IGNORE THIS LINE Scheduler.getInstance().run();
    	boolean currentButtonState = mainstick.getRawButton(4);
    	

    	
    	drivetrain.arcadeDrive(mainstick.getY(), mainstick.getX());
    	
    	if (driveControl == 2){
    	
       	double speedLimit = 0.7;
    	double mainstickSped = mainstick.getX();
    	
    	if (mainstickSped > speedLimit){
    		mainstickSped = speedLimit;
    	} if (mainstickSped < - speedLimit){
    		mainstickSped = speedLimit;
    		
    	}
	double mainstickSped2 = mainstick.getY();
    	
    	if (mainstickSped2 > speedLimit){
    		mainstickSped2 = speedLimit;
    	} if (mainstickSped2 < - speedLimit){
    		mainstickSped2 = speedLimit;
    	}
  
    	}
    	
    	//elevator.drive(ada.getY());
    	

    double throttlee = ada.getY();{
    
    	
    	if (throttlee > 0.7){
    		throttlee = 0.7;
    	} if (throttlee < -0.7){
    		throttlee = -0.7;
    	}
    	
    	elevator.drive(throttlee);
    	

    	
    	
    	//This prints out the elevator's height
    	System.out.println(elevator.getCurrentHeight());

    	
    	//This if is for some safety so you can't extend the platform and rip off our elevator.
    	if (elevator.getCurrentHeight() > Constants.PLATFORM_TOGGLE_HEIGHT_LIMIT) {
    		if(currentButtonState && ! previousButtonState){
    			if(platform1.isExtended()){
    				platform1.retract();
    				psi -= 30;
    				System.out.println("psi dropping on retract");
    			}
    			else{
    				platform1.extend();
    				psi -= 30;
    				System.out.println("psi dropping on extend");
    			}
    		}
    		
    		
    	}
    	
    	//This updates the elevator's height when it hits limit switches
    	previousButtonState = currentButtonState;
    	elevator.update();
    	if (compressor.getPressureSwitchValue()){
    		psi = 110;
    
        }
    	else{
    		psi = (psi + .02);
        	
        }
    	System.out.println("psi= " + psi);
    }
   

    	
    	

    }
    
   
    public void testPeriodic() {
        LiveWindow.run();
    }
}
