package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Compressor;
/**
 *@author H(small 2)Olivia Rules 
 */
public class CompressorSubsystem extends Subsystem {
	Compressor compressor;

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public CompressorSubsystem(){
	
	 compressor = new Compressor();
	
}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void startComp(){
    	compressor.start();
    }
    public void stopComp(){
    	compressor.stop();
    }
}

