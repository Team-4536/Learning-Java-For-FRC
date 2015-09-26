package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Piston extends Subsystem{
	
	Timer extendedTimer;
	Timer retractedTimer;
	Solenoid leftSolenoid;
	Solenoid rightSolenoid;
	
	/**
	 * @author Stepan
	 * @param leftSolenoidChannel channel that the left solenoid is plugged into on the roboRIO
	 * @param rightSolenoidChannel channel that the right solenoid is plugged into on the roboRIO
	 */
	public Piston(int leftSolenoidChannel, int rightSolenoidChannel) {
		leftSolenoid = new Solenoid(leftSolenoidChannel);
		rightSolenoid = new Solenoid(rightSolenoidChannel);
		
		extendedTimer = new Timer();
		retractedTimer = new Timer();
		
		extendedTimer.start();
		retractedTimer.start();
	}
	
	public void initDefaultCommand() {
	    // Set the default command for a subsystem here.
	    //setDefaultCommand(new MySpecialCommand());	    	
	}
	
	/**
	 * @author Stepan
	 */
	public void retract() {
		leftSolenoid.set(true);
		rightSolenoid.set(false);
	}
	
	/**
	 * @author Stepan
	 */
	public void extend() {
		leftSolenoid.set(false);
		rightSolenoid.set(true);
	}
	
	/**
	 * @author Stepan
	 * Sets the state of piston as the opposite of its current state
	 */
	public void flip() {
		leftSolenoid.set(!leftSolenoid.get());
		rightSolenoid.set(!rightSolenoid.get());
	}
	
	/**
	 * @author Stepan
	 */
	public boolean isExtended() {
		return rightSolenoid.get();
	}
	
	/**
	 * @author Stepan
	 * @return amount of time that the piston has been extended (in milliseconds)
	 */
	public double timeExtended() {
		if(this.isExtended()) {
			return extendedTimer.get();
		}
		else {
			extendedTimer.reset();
			return 0;
		}
	}
	
	/**
	 * @author Stepan
	 * @return amount of time that the piston has been retracted (in milliseconds)
	 */
	public double timeRetracted() {
		if(!this.isExtended()) {
			return retractedTimer.get();
		}
		else {
			retractedTimer.reset();
			return 0;
		}
	}
}


