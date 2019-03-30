/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetElevatorToTarget extends Command {
  private final int m_setpoint;
  private double[] m_onTargetBuffer = new double[10];

  public SetElevatorToTarget(int targetValue) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_elevator);
    m_setpoint = targetValue;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_elevator.enable();
    Robot.m_elevator.setSetpoint(m_setpoint);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    boolean isOnTarget = updateOnTargetBuffer(Robot.m_elevator.onTarget());
    return isOnTarget;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_elevator.stopElevator();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.m_elevator.stopElevator();
  }

  // simple buffer to smooth onTarget evaluation
  protected boolean updateOnTargetBuffer(boolean newTargetVal){
    double sumOfValues = 0.0;
    for (int i = 0; i < m_onTargetBuffer.length - 1; i++){
      m_onTargetBuffer[i] = m_onTargetBuffer[i+1];
      sumOfValues += m_onTargetBuffer[i];
    }
    double temp = newTargetVal ? 1.0 : 0.0;
    m_onTargetBuffer[m_onTargetBuffer.length - 1] = temp;
    sumOfValues += temp;
    
    return (sumOfValues / m_onTargetBuffer.length) > 0.95;
  }
}
