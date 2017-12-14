package org.usfirst.frc.team199.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//TODO : Make general which motors are Pwm and which ones are Can
	public static TalonSRX leftForwMotor;
	public static TalonSRX rightForwMotor;
	public static TalonSRX leftBackMotor;
	public static TalonSRX rightBackMotor;
	
	public static RobotDrive robotDrive;
	
	public static DoubleSolenoid dtGear;
	
	public RobotMap() {
		leftForwMotor = new TalonSRX((int)Robot.getPref("Ports: leftForwMotor", 0));
		rightForwMotor = new TalonSRX((int)Robot.getPref("Ports: rightForwMotor", 1));
		leftBackMotor = new TalonSRX((int)Robot.getPref("Ports: leftBackMotor", 2));
		rightBackMotor = new TalonSRX((int)Robot.getPref("Ports: rightBackMotor", 3));
		
		robotDrive = new RobotDrive(leftForwMotor, leftBackMotor, rightForwMotor, rightBackMotor);
		robotDrive.setMaxOutput(Robot.getPref("driveSpeedMult", 1));
		
		dtGear = new DoubleSolenoid((int)Robot.getPref("dtGearPort1", 0), (int)Robot.getPref("dtGearPort2", 1));
	}
}
