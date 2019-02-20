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
public class CargoVacuum extends Subsystem {
  WPI_TalonSRX cargoVacuumMotor;

  public CargoVacuum(){
    cargoVacuumMotor = new WPI_TalonSRX(RobotMap.cargoVacuumPort);
  }

  public void activateVacuum(){
    cargoVacuumMotor.set(ControlMode.PercentOutput, 1.0);
  }

  public void deactivateVacuum(){
    cargoVacuumMotor.set(ControlMode.PercentOutput, 0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
