/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchVacuum extends Subsystem {
  WPI_TalonSRX leftHatchVacuumMotor;
  WPI_TalonSRX rightHatchVacuumMotor;

  public HatchVacuum(){
    leftHatchVacuumMotor = new WPI_TalonSRX(RobotMap.hatchVacuumPort1);
    rightHatchVacuumMotor = new WPI_TalonSRX(RobotMap.hatchVacuumPort2);
  }

  public void activateVacuum(){
      leftHatchVacuumMotor.set(ControlMode.PercentOutput, 1.0);
      rightHatchVacuumMotor.set(ControlMode.PercentOutput, 1.0);
  }

  public void deactivateVacuum(){
      leftHatchVacuumMotor.set(ControlMode.PercentOutput, 0.0);
      rightHatchVacuumMotor.set(ControlMode.PercentOutput, 0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
