package org.usfirst.frc.team4536.robot.subsystems;

public class Platform extends Piston {
	
	public Platform(int leftSolenoidChannel, int rightSolenoidChannel) {
		super(leftSolenoidChannel, rightSolenoidChannel);
		retract();
	}
	
}

