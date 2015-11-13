package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.DigitalInput;


public class Elevator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
 
 public Jaguar elevatorJaguar;
 
 
 public Elevator (int jaguarChannel)
 {
  elevatorJaguar = new Jaguar(jaguarChannel);

     
 }

 	
 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here
        //setDefaultCommand(new MySpecialCommand()); 
    }
}

