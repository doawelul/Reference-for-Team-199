package org.usfirst.frc.team199.robot.commands;

import org.usfirst.frc.team199.robot.Robot;
import org.usfirst.frc.team199.robot.RobotMap;
import org.usfirst.frc.team199.robot.motion.PID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDDrive extends Command {

	double target;
    public PIDDrive(double targ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	target = targ;
    	requires(Robot.dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dt.enableMoveLeftPid();
    	Robot.dt.enableMoveRightPid();
    	Robot.dt.setSetMoveLeft(target);
    	Robot.dt.setSetMoveRight(target);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.dt.onTargetLeft() && Robot.dt.onTargetRight();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dt.stopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
