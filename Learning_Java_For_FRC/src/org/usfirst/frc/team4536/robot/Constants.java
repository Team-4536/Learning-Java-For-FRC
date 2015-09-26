package org.usfirst.frc.team4536.robot;

public class Constants {

	/*---------------------------------------Drive Train--------------------------------*/
	
	public static final double FORWARD_SPEED_CURVE = 2;
	public static final double TURN_SPEED_CURVE = 2;
	public static final double FORWARD_FULL_SPEED_TIME = 2.0;
	public static final double TURN_FULL_SPEED_TIME = 2.0;
	
	/*---------------------------------------Joystick-----------------------------------*/
	
	public static final double DEAD_ZONE = 0.05;
	
	/*-------------------------------------Elevator Constants-----------------------------------*/ 
	
   	public static final double ELEVATOR_PROPORTIONALITY_CONSTANT = .5; //Units of throttle/inch
   	public static final double TICKS_PER_INCHES = 247.7; //Converts encoder ticks to measurable inches
   	public static final double PLATFORM_TOGGLE_HEIGHT_LIMIT = 8.4; // platform can't be toggled when the elevator is at this height in inches and below.
   	
   	public static final double TOP_LIMIT_SWITCH_HEIGHT = 48;
   	public static final double MIDDLE_LIMIT_SWITCH_HEIGHT = 8;
   	public static final double BOTTOM_LIMIT_SWITCH_HEIGHT = -0.5;
   	
   	/*---------------------------------------Power Distribution Panel----------------------*/
   	
   	public static final int PDP_SLOTS = 16;
   	
   	/*---------------------------------------Encoder--------------------------------------*/
   	
   	//(Right side)
   	public static final int ENCODER_SLOT_A = 9;
   	public static final int ENCODER_SLOT_B = 8;
}

