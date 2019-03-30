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

public class SolvePNPTest extends Command {
  private boolean m_LimelightHasValidTarget;
  private double m_LimelightDriveCommand;
  private double m_LimelightRotateCommand;
  private double m_LimelightStrafeCommand;

  public SolvePNPTest() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.setLimelightPipeline(RobotMap.limelightPipelineTargetBasic);
    m_LimelightHasValidTarget = false;
    m_LimelightDriveCommand = 0.0;
    m_LimelightRotateCommand = 0.0;
    m_LimelightStrafeCommand = 0.0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    updateLimelight3DTracking();
    Robot.m_chassis.driveCartesian(m_LimelightStrafeCommand, m_LimelightDriveCommand, m_LimelightRotateCommand);
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

  private void updateLimelight3DTracking(){
    // These numbers must be tuned for your Robot!  Be careful!
    final double ROTATE_K = 0.04;                    // how hard to turn toward the target
    final double STRAFE_K = 0.04;
    final double DRIVE_K = 0.25;                    // how hard to drive fwd toward the target
    final double CAMERA_OFFSET = -8.00;      //camera is mounted on left edge of robot and is thus some inches off of center target
    final double DESIRED_TARGET_DISTANCE = 48.0;        // distance in inches along z axis from target
    final double MAX_DRIVE = 0.5;                   // Simple speed limit so we don't drive too fast

    NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
    double[] camtran = limelightTable.getEntry("camtran").getDoubleArray(new double[6]);
    double yaw = camtran[4];
    double xVal = camtran[0];
    double zVal = camtran[2];
    double tv = limelightTable.getEntry("tv").getDouble(0);
    double ta = limelightTable.getEntry("ta").getDouble(0);

    if (tv < 1.0)
    {
      m_LimelightHasValidTarget = false;
      m_LimelightDriveCommand = 0.0;
      m_LimelightStrafeCommand = 0.0;
      m_LimelightRotateCommand = 0.0;
      return;
    }

    m_LimelightHasValidTarget = true;

    double strafe_cmd = (CAMERA_OFFSET - xVal) * STRAFE_K;
    m_LimelightStrafeCommand = strafe_cmd;

    double rotate_cmd = yaw * ROTATE_K;
    m_LimelightRotateCommand = rotate_cmd;

    // try to drive forward until the target area reaches our desired area
    double drive_cmd = (DESIRED_TARGET_DISTANCE - zVal) * DRIVE_K;

    // don't let the robot drive too fast into the goal
    if (drive_cmd > MAX_DRIVE)
    {
      drive_cmd = MAX_DRIVE;
    }
    m_LimelightDriveCommand = drive_cmd;

  }
}
