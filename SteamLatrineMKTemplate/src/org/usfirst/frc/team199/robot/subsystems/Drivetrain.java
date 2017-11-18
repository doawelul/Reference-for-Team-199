package org.usfirst.frc.team199.robot.subsystems;

import org.usfirst.frc.team199.robot.Robot;
import org.usfirst.frc.team199.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	
	private final TalonSRX leftForwMotor = RobotMap.leftForwMotor;
	private final TalonSRX rightForwMotor = RobotMap.rightForwMotor;
	private final CANTalon leftBackMotor = RobotMap.rightBackMotor;
	private final CANTalon rightBackMotor = RobotMap.rightBackMotor;
	
	private final RobotDrive robotDrive = RobotMap.robotDrive;
	
	private final DoubleSolenoid dtGear = RobotMap.dtGear;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private double average(double a, double b) {
		return (a+b)/2;
	}
	
	public void stopDrive() {
		leftForwMotor.stopMotor();
		rightForwMotor.stopMotor();
		leftBackMotor.set(0);;
		rightBackMotor.set(0);
	}
	
	public void setDtGear(int dir) {
		switch((int)Math.signum(dir)) {
			case -1:
				dtGear.set(DoubleSolenoid.Value.kReverse);
				break;
			case 0:
				dtGear.set(DoubleSolenoid.Value.kOff);
				break;
			case 1:
				dtGear.set(DoubleSolenoid.Value.kForward);
				break;
			default:
				Robot.getPref("visionWorks", false);
		}
	}
	public void arcadeDrive(double move, double turn) {
		robotDrive.arcadeDrive(move, turn);
	}
	public void tankDrive(double left, double right) {
		robotDrive.tankDrive(left, right);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

