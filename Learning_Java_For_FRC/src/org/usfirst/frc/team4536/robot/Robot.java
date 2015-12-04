/**
 * @author Max and Simiolos
 * These lines below are what we call imports. Imports are
 * a way for us to import code made by other people so that
 * we can use it. We are importing a bunch of code here to 
 * take care of the base code of running a robot such as 
 * collection data from robot systems and interfacing with joysticks!
 */
package org.usfirst.frc.team4536.robot;
import org.usfirst.frc.team4536.robot.commands.DriveTrainCommand;
import org.usfirst.frc.team4536.robot.subsystems.Piston;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;



public class Robot extends IterativeRobot {
	DriveTrainCommand driveTrainCommand;
	Piston piston = new Piston(RobotMap.RIGHT_SOLENOID, RobotMap.LEFT_SOLENOID);
    public void robotInit() { 	
    	
    	driveTrainCommand = new DriveTrainCommand();
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
    	if(driveTrainCommand != null){		
    		driveTrainCommand.start();
    		}
    	}
    public void disabledInit(){
    }
    public void teleopPeriodic() {
       Scheduler.getInstance().run();
       boolean extend = OI.mainStick.getRawButton(3);

       if(extend){
    		piston.extend();
      	}    
    boolean retract = OI.mainStick.getRawButton(4);
    	if(retract){
    	piston.retract();
    	}
    }
    public void testPeriodic() {
        LiveWindow.run();
    }
}
