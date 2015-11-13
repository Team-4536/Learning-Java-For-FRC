
package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.subsystems.*;
import org.usfirst.frc.team4536.robot.commands.*;
import org.usfirst.frc.team4536.robot.commands.CommandBase;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	
	Command elevatorCommand;
    Command autonomousCommand;
    Command rightFeederStationAuto;
    Command leftFeederStationAuto;
    Command driveCommand;
    Command compressorCommand;
    Command tankDriveCommand;
    Command toggleCanbuglerCommand;
    Command smartDashboardCommand;
    Command fileWriteCommand;
    Command fileReadCommand;
    SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		elevatorCommand = new ElevatorCommand();
       /* // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
        rightFeederStationAuto = new RightFeederStationAutonomous();
        leftFeederStationAuto = new LeftFeederStationAutonomous();
        driveCommand = new Drive();
        compressorCommand = new RunCompressor();
        tankDriveCommand = new TankDrive();
        toggleCanbuglerCommand = new ToggleCanburgler();
        smartDashboardCommand = new SmartDashboardCommand();
        
        SmartDashboard.putData(Scheduler.getInstance());
        
        
        Utilities.startTimer();
        SmartDashboard.putData(Scheduler.getInstance());
        
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Do Nothing", 0);
        autoChooser.addObject("Left Feeder Station", 1);
        autoChooser.addObject("Right Feeder Station", 2);
        SmartDashboard.putData("autoChooser", autoChooser);*/
        	
   
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        /*// schedule the autonomous command (example)
        if(autonomousCommand != null) 
        	autonomousCommand.start();
        if(compressorCommand != null)
            compressorCommand.start();
        if(smartDashboardCommand != null) 
        	smartDashboardCommand.start();

        CommandBase.driveTrain.gyroReset();*/
        
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
       /* switch ((int) autoChooser.getSelected().hashCode()){
        		case 0: CommandBase.driveTrain.arcadeDrive(0, 0);
        				break;
        		case 1: rightFeederStationAuto.start();
        				break;
        		case 2: leftFeederStationAuto.start();
        				break;
        		default: CommandBase.driveTrain.arcadeDrive(0, 0);
        				break;
        }*/
    }

    public void teleopInit() {
    	if(elevatorCommand != null)
    	{
    		elevatorCommand.start();
    	}
    	}
    	// This makes sure that the autonomous stops running when
       /* // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	
        if(autonomousCommand != null) {        	
        	Utilities.resetTimer();
        	autonomousCommand.cancel();
        }
//        if(driveCommand != null)
//        	driveCommand.start();
        if(driveCommand != null)
        	driveCommand.start();
        if(smartDashboardCommand != null) 
        	smartDashboardCommand.start();
        
        SmartDashboard.putData(CommandBase.canburgler);
        SmartDashboard.putData(CommandBase.compSub);
        SmartDashboard.putData(CommandBase.driveTrain);
        SmartDashboard.putData(CommandBase.elevator);
        SmartDashboard.putData(CommandBase.platform);
        
        CommandBase.driveTrain.disable();
        }*/
    

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	/*if (driveCommand != null) 
        	driveCommand.cancel();
        if (compressorCommand != null) 
        	compressorCommand.cancel();*/
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        /*SmartDashboard.putData(CommandBase.driveTrain);
        SmartDashboard.putData(CommandBase.elevator);*/
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
