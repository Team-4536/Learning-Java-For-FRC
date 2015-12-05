package org.usfirst.frc.team4536.robot.subsystems;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Piston extends Subsystem {

    Solenoid rightSolenoid;
    Solenoid leftSolenoid;

    public Piston (int rightSolenoidChannel,int leftSolenoidChannel){

        rightSolenoid = new Solenoid(rightSolenoidChannel);
        leftSolenoid = new Solenoid(leftSolenoidChannel);


    };
    public void extend() {

        leftSolenoid.set(false);
        rightSolenoid.set(true);
        
    }
    public void retract() {

        leftSolenoid.set(true);
        rightSolenoid.set(false);
        
    }
    public void initDefaultCommand() {
    }
	}


