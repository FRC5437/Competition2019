/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  WPI_TalonSRX elevatorMotor;

  public Elevator(){
    elevatorMotor = new WPI_TalonSRX(RobotMap.elevatorPort);
    elevatorMotor.configOpenloopRamp(0.5);
    elevatorMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setElevatorSpeed(double drivePercent){
      elevatorMotor.set(ControlMode.PercentOutput, drivePercent);
  }
}
