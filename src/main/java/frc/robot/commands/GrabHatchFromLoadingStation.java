/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class GrabHatchFromLoadingStation extends Command {
  private boolean m_LimelightHasValidTarget;
  private double m_LimelightDriveCommand;
  private double m_LimelightSteerCommand;


  public GrabHatchFromLoadingStation() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.setLimelightPipeline(RobotMap.limelightPipelineTargetBasic);
    m_LimelightHasValidTarget = false;
    m_LimelightDriveCommand = 0.0;
    m_LimelightSteerCommand = 0.0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    updateLimelightTracking();
    Robot.m_chassis.driveCartesian(0.0, m_LimelightDriveCommand, m_LimelightSteerCommand);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.setLimelightPipeline(RobotMap.limelightPipelineDefault);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.setLimelightPipeline(RobotMap.limelightPipelineDefault);

  }

  private void updateLimelightTracking(){
    // These numbers must be tuned for your Robot!  Be careful!
    final double STEER_K = 0.04;                    // how hard to turn toward the target
    final double DRIVE_K = 0.25;                    // how hard to drive fwd toward the target
    final double DESIRED_TARGET_AREA = 4.0;        // Area of the target when the robot reaches the wall
    final double MAX_DRIVE = 0.7;                   // Simple speed limit so we don't drive too fast

    NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight");

    double tv = limelightTable.getEntry("tv").getDouble(0);
    double tx = limelightTable.getEntry("tx").getDouble(0);
    double ty = limelightTable.getEntry("ty").getDouble(0);
    double ta = limelightTable.getEntry("ta").getDouble(0);

    if (tv < 1.0)
    {
      m_LimelightHasValidTarget = false;
      m_LimelightDriveCommand = 0.0;
      m_LimelightSteerCommand = 0.0;
      return;
    }

    m_LimelightHasValidTarget = true;

    // Start with proportional steering
    double steer_cmd = tx * STEER_K;
    m_LimelightSteerCommand = steer_cmd;

    // try to drive forward until the target area reaches our desired area
    double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;

    // don't let the robot drive too fast into the goal
    if (drive_cmd > MAX_DRIVE)
    {
      drive_cmd = MAX_DRIVE;
    }
    m_LimelightDriveCommand = drive_cmd;
  }
}
