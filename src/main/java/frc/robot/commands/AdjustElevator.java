package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AdjustElevator extends Command {
  public AdjustElevator() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Trigger axes are all positive - so treat the left as negative and sum with the right to get a full range
    double stickInput = Robot.m_oi.getXboxDrive().getTriggerAxis(Hand.kLeft) + (-1.0 * Robot.m_oi.getXboxDrive().getTriggerAxis(Hand.kRight));
		if (Math.abs(stickInput) < 0.1) {
			stickInput = 0.0;
		}
		Robot.m_elevator.adjustElevator(stickInput);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
