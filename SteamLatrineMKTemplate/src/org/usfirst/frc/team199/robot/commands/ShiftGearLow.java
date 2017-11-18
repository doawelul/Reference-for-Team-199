package org.usfirst.frc.team199.robot.commands;

import org.usfirst.frc.team199.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftGearLow extends Command {

	Timer tim = new Timer();
    public ShiftGearLow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	tim.reset();
    	tim.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dt.setDtGear((int)(-1*Robot.getPref("dtGearDir", 1)));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return tim.get() >= 0.0125;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dt.setDtGear(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
