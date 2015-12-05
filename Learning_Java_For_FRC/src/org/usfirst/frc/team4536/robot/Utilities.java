package org.usfirst.frc.team4536.robot;

import java.lang.Math;

public class Utilities {
	
	/**
	 * @author Nerd
	 * @param speed to be limited
	 * @param min speed will be no less than.
	 * @param max speed will be no greater than
	 * @return speed between minimum and maximum
	 */
	public static double limit (double speed, double min, double max){
		if(speed < min){
			speed = min;
		}
		if(speed > max){
			speed = max;
		}
		return speed;
	}
	
	/**
	 * @author Nerd
	 * @param speed to be limited
	 * @param bound speed will be no less than negative bound and no greater than positive bound
	 * @return speed between negative bound and positive bound
	 */
	public static double limit (double speed, double bound){
		speed = limit(speed, -bound, bound);
		return speed;
	}
	
	/**
	 * @author Nerd
	 * @param speed will be no greater than 1 and no less than -1
	 * @return speed between 1 and -1
	 */
	public static double limit (double speed){
		speed = limit(speed, 1);
		return speed;
	}
	
	/**
	 * @author Nerd
	 * @param speed between -1 and 1 to be limited
	 * @param curve can not be negative, curves speed to negative or positive speed
	 * @return curved speed
	 */
	public static double speedCurve(double speed, double curve){
		double limitedCurve = curve;
		if(curve < 0){
			limitedCurve = 0;
		}
		if(speed < 0){
			speed = -(Math.pow(-speed, limitedCurve));
		}
		else{
			speed = Math.pow(speed, limitedCurve);
		}
		return speed;
	}
	
	/**
	 * @author Nerd
	 * @param throttle input throttle to be limited
	 * @param prevThrottle input previous throttle
	 * @param accelerationLimit limits throttle to acceleration limit if increased by more than acceleration limit 
	 * 		or decreased by more than acceleration limit
	 * @return limited throttle
	 */
	public static double accelLimit(double throttle, double prevThrottle, double accelerationLimit){
		double limitedThrottle = throttle;
		double throttleDiff = throttle - prevThrottle;
		double modifiedAccelLimit = 0.02 / accelerationLimit;
		if(throttleDiff > modifiedAccelLimit){
			limitedThrottle = prevThrottle + modifiedAccelLimit;
		}
		else if(throttleDiff < -modifiedAccelLimit){
			limitedThrottle = prevThrottle - modifiedAccelLimit;
		}
		return limitedThrottle;
	}
	
	/**
	 * @author Nerd
	 * @param limited speed speed to be limited
	 * @param zone that makes speed O
	 * @param speed is 0 if it is bewteen zone and -zone
	 * @return limited speed
	 */
	public static double deadZone(double speed, double zone){
		double limitedSpeed = speed;
		if(limitedSpeed < zone && limitedSpeed > -zone){
			speed = 0;
		}
		return speed;
	}
}
