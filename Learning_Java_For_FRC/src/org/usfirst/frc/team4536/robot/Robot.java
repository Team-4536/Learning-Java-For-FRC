/**
 * @author Max
 */
package org.usfirst.frc.team4536.robot;
import org.usfirst.frc.team4536.robot.commands.*;
import org.usfirst.frc.team4536.robot.subsystems.Piston;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Command;



public class Robot extends IterativeRobot {
	DriveTrainCommand driveTrainCommand;
	Command pistonCommand;
    public void robotInit() { 	
    	
    	driveTrainCommand = new DriveTrainCommand();
    	pistonCommand = new Piston_Extend();
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
    	if(pistonCommand != null){
    		pistonCommand.start();
    	}
    	
    	
    }
    
    
    public void disabledInit(){
    }
    public void teleopPeriodic() {
       Scheduler.getInstance().run();
      
    }
    public void testPeriodic() {
        LiveWindow.run();
    }
}
