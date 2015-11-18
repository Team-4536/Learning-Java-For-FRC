package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
/**
 *
 */
public class Elevator extends Subsystem {
	Jaguar jmotor;
    public Elevator(int jaguarChannel){
     jmotor = new Jaguar(jaguarChannel);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void drive(double speed){
    	jmotor.set(speed);
    }
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

