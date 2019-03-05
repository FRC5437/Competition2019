/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Solenoid clawSolenoid;
  Solenoid shoulderSolenoid;
  Solenoid elbowSolenoid;

  public Claw(){
    clawSolenoid = new Solenoid(RobotMap.solenoidClaw);
    shoulderSolenoid = new Solenoid(RobotMap.solenoidShoulder);
    elbowSolenoid = new Solenoid(RobotMap.solenoidElbow);
  }

  public void initialize(){
    clawSolenoid.set(true);
    shoulderSolenoid.set(true);
    elbowSolenoid.set(true);
  }

  public void closeClaw(){
    clawSolenoid.set(false);
  }

  public void openClaw(){
    clawSolenoid.set(true);
  }

  public void extendElbow(){
    elbowSolenoid.set(false);
  }

  public void retractElbow(){
    elbowSolenoid.set(true);
  }

  public void extendShoulder(){
    shoulderSolenoid.set(false);
  }

  public void retractShoulder(){
    shoulderSolenoid.set(true);
  }

  public boolean getClawState(){
    return clawSolenoid.get();
  }

  public boolean getElbowState(){
    return elbowSolenoid.get();
  }

  public boolean getShoulderState(){
    return shoulderSolenoid.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
