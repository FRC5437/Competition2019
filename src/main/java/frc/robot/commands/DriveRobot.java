/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveRobot extends Command {
  public DriveRobot() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      XboxController xboxDrive = Robot.m_oi.getXboxDrive();
      Robot.m_chassis.driveCartesian(getEnhancedJoystickInput(xboxDrive.getRawAxis(RobotMap.leftStickXAxis)), 
                                   -1.0 * getEnhancedJoystickInput(xboxDrive.getRawAxis(RobotMap.leftStickYAxis)), 
                                    getEnhancedJoystickInput(xboxDrive.getRawAxis(RobotMap.rightStickXAxis)));
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

  /**
   * square the value while retaining sign and implement a deadband
   * @param rawValue - expected to represent a joystick axis value
   * @return modifiedValue which has retained the sign but squared the value and implemented a deadband for small rawValues
   */
  private double getEnhancedJoystickInput(double rawValue){
    int sign = (int) Math.signum(rawValue);
    double modifiedValue = rawValue * rawValue;
    //deadband
    if (modifiedValue < 0.05) {
        modifiedValue = 0.0;
    }

    return sign * modifiedValue;
  }
}
