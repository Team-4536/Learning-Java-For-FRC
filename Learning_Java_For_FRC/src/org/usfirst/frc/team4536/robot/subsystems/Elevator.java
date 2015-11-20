package org.usfirst.frc.team4536.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Elevator extends Subsystem {
	Jaguar jmotor;
	DigitalInput limitSwitch;
    public Elevator(int jaguarChannel){
     jmotor = new Jaguar(jaguarChannel);
     limitSwitch = new DigitalInput(3);
    }
     //TODO  Make public boolean getLimitSwitchValueS
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public boolean sensor(){
    	if(limitSwitch.get()){
    		return true;
    	}return false;
    }
    public void drive(double speed){
    	jmotor.set(speed);
    }
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}



