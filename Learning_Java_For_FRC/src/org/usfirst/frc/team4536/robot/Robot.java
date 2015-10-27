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
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team4536.robot.subsystems.*;

/**
 * @author Liam
 * Code runs in cycles of about 20 ms (miliseconds) so
 * it executes your code and any changes to your code
 * in 20 ms intervals. As you look through this code you
 * will see things ending with "init" and that means that
 * the code in there gets executed in only one cycle so
 * there's no dynamic changing of values. Things which end
 * with "periodic" update the robot every cycle of code while
 * the robot is in their corresponding mode (robot, disabled,
 * teleop, autonomous.) For example: teleopPeriodic would be
 * sending code with any changes to its values every 20 ms. This
 * is important when you're driving a robot off of a joystick so
 * the motors are getting as up to date values as possible.
 */
public class Robot extends IterativeRobot {
	
	/**
	 * =============================
	 * =============================
	 * MAKE A JOYSTICK BELOW HERE!!!
	 * =============================
	 * =============================
	 */
	Joystick ada = new Joystick(0);
	
	/**
	 * =====================
	 * =====================
	 * MAKE AN ELEVATOR HERE
	 * =====================
	 * =====================
	 */
	Elevator elevator = new Elevator(RobotMap.ELEVATOR_MOTOR,
							RobotMap.ELEVATOR_ENCODER_A_CHANNEL,
							RobotMap.ELEVATOR_ENCODER_B_CHANNEL,
							RobotMap.TOP_LIMIT_SWITCH,
							RobotMap.MIDDLE_LIMIT_SWITCH,
							RobotMap.BOTTOM_LIMIT_SWITCH);
	
	/*
			RobotMap.ELEVATOR_ENCODER_A_CHANNEL,
			RobotMap.ELEVATOR_ENCODER_B_CHANNEL,
			RobotMap.TOP_LIMIT_SWITCH,
			RobotMap.MIDDLE_LIMIT_SWITCH,
			RobotMap.BOTTOM_LIMIT_SWITCH);
	*/
	
	/**
	 * ====================
	 * ====================
	 * MAKE A PLATFORM HERE
	 * ====================
	 * ====================
	 */
	
	/**
	 * @author Liam
	 * Put code here that you want to run ONCE at startup.
	 * These will be the first things your code does.
	 */
    public void robotInit() {
    	
    }
	
    /**
     * @author Liam
     * Disabled periodic is when the robot has power and is turned on
     * but we haven't enabled it. There shouldn't be any code running
     * systems in here because it is highly unsafe because you can't
     * stop the robot as easily while it's supposed to be disabled.
     */
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * @author Liam
	 * Autonomous is a period with no user control where
	 * the robot operates all by itself.
	 * autonomousInit is called ONCE. All values in here
	 * are the first values executed in autonomous. Systems
	 * will hold these values until given new ones. If I gave
	 * the motors a value of "1" which indicates full speed
	 * forward, the robot would go racing forward indefinitely
	 * if I don't give it a different value in the next cycle
	 * of code (which is autonomousPeriodic).
	 */
    public void autonomousInit() {
    	
    }

    /**
     * @author Liam
     * autonomousPeriodic is called every cycle of code
     * after autonomousInit during the autonomous period
     * (where the robot is controlling itself).
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * @author Liam
     * Teleop is a period during which humans may operate
     * the robot using controllers like joysticks,
     * button boxes, or XBox controllers. TeleopInit is
     * called ONCE at the beginning of the teleop period.
     * You should make sure all autonomous commands are
     * stopped at this point and new ones for teleop are
     * given.
     */
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    }

    /**
     * @author Liam
     * disabledInit is the first thing called when the disabled button is hit.
     * Disabled is also the state you robot starts in.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * TeleopPeriodic is the dynamic segment of teleop which updates code
     * every cycle of code during the teleop period. Recall: a cycle of code
     * is 20 ms. The teleop time period is 2 minutes and 10 - 15 seconds long
     * in typical competition years so you update your robot with what's going
     * on on your joystick alot!
     */
    /**
     * ==========================================
     * ==========================================
     * FIRST DAY ROBOTICS STUDENTS CONTINUE HERE!
     * ==========================================
     * ==========================================
     */
    public void teleopPeriodic() {
        // IGNORE THIS LINE Scheduler.getInstance().run();
    	
    	/**
    	 * =============================================================
    	 * =============================================================
    	 * REPLACE THE "0.0"s WITH THE Y-AXIS and X-AXIS OF THE JOYSTICK
    	 * =============================================================
    	 * =============================================================
    	 */
    	
    	/**
    	 * ===================================================
    	 * ===================================================
    	 * MAKE THE ELEVATOR DRIVE OFF OF A JOYSTICK AXIS HERE
    	 * ===================================================
    	 * ===================================================
    	 */
    	//elevator.drive(ada.getY());
    	

    	double throttlee = ada.getY();
    	
    	if (throttlee > 0.25){
    		throttlee = 0.25;
    	} if (throttlee < -0.25){
    		throttlee = -0.25;
    	}
    	
    	elevator.drive(throttlee);
    	
    	
    	
    	//This prints out the elevator's height
    	System.out.println(elevator.getCurrentHeight());
    }
    
    /**
     * testPeriodic executes its code every cycle except the first
     * during the test period. The test period is just a way to test.
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
