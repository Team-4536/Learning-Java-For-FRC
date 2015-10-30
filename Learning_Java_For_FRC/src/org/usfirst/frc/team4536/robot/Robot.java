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
import edu.wpi.first.wpilibj.Gyro;

import org.usfirst.frc.team4536.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team4536.robot.subsystems.*;

/**
 * @author Liam
 
 */
public class Robot extends IterativeRobot {
	

	DriveTrain driveTrain = new DriveTrain(RobotMap.LEFT_MOTOR, RobotMap.RIGHT_MOTOR);
	
	boolean previousButtonState = false;
	
	double psi = 110;

	
	Joystick forttle = new Joystick(1);
	Joystick ada = new Joystick(0);
	

	DriveTrain drivetrain = new DriveTrain(1,0);
	
	
	Gyro gyro1 = new Gyro(RobotMap.GYRO);
	
	Joystick mainJoystick = new Joystick(0);
	
	Joystick secondJoystick = new Joystick(1);


	Elevator elevator = new Elevator(RobotMap.ELEVATOR_MOTOR,
							RobotMap.ELEVATOR_ENCODER_A_CHANNEL,
							RobotMap.ELEVATOR_ENCODER_B_CHANNEL,
							RobotMap.TOP_LIMIT_SWITCH,
							RobotMap.MIDDLE_LIMIT_SWITCH,
							RobotMap.BOTTOM_LIMIT_SWITCH);



	
	Platform platform1 = new Platform (3,2);
	Compressor compressor = new Compressor ();

	
	
    public void robotInit() {
    	gyro1.initGyro();
    	
    }
	
   
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
    	boolean currentButtonState = mainJoystick.getRawButton(4);
    	
    	double angle = gyro1.getAngle();
    	

    	
    	drivetrain.arcadeDrive(forttle.getY(), forttle.getX());
    	double speedLimit1 = 0.25;
    	double sped = forttle.getY();
    	if (sped > speedLimit1){
    		sped = speedLimit1;
    	} if (sped < -speedLimit1);
    	double sped2 = forttle.getX();
    	if (sped2 > speedLimit1){
    		sped2 = speedLimit1;
    	} if (sped2 < -speedLimit1){
    		sped2 = -speedLimit1;
    	}
    	
    	//deadzone
    	double deadZone = 0.25;
    	double fast = forttle.getY();
    	if (fast > speedLimit1){
    		fast = speedLimit1;
    	} if (fast < -speedLimit1);
    	double fast2 = forttle.getX();
    	if (fast2 > speedLimit1){
    		fast2 = speedLimit1;
    	} if (fast2 < -speedLimit1){
    		fast2 = -speedLimit1;
    	}
    	
    	
    	
    	
    	
    	
    	//elevator.drive(ada.getY());
    	

    	double throttlee = ada.getY();
    	double speedLimit = 1.0;
    	
    	if (throttlee > speedLimit){
    		throttlee = speedLimit;
    	} if (throttlee < -speedLimit){
    		throttlee = -speedLimit;
    	}
    	
    	elevator.drive(throttlee);
    	

    	
    	
    	//This prints out the elevator's height
    	System.out.println(elevator.getCurrentHeight());

    	if ( angle == 69 ){
    		
    		System.out.println("lol 69");
    		
    	}
    	
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
    	
    	System.out.println("angle = " + angle);
   

    	
    	

    }
    
   
    public void testPeriodic() {
        LiveWindow.run();
    }
}
