/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import frc.robot.RobotMap;
import frc.robot.commands.DriveRobot;

/**
 * Add your docs here.
 */
public class Chassis extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  MecanumDrive mecanumDrive;
  WPI_TalonSRX frontLeft;
  WPI_TalonSRX rearLeft;
  WPI_TalonSRX frontRight;
  WPI_TalonSRX rearRight;

  // Subsystems are created as soon as the robot program starts - move any initialization that needs to wait
  // for robot init or the activation of a game mode into new public methods to be invoked from the robot object
  // at that time.
  public Chassis(){
    frontLeft = new WPI_TalonSRX(RobotMap.frontLeftMecanumPort);
    rearLeft = new WPI_TalonSRX(RobotMap.rearLeftMecanumPort);
    frontRight = new WPI_TalonSRX(RobotMap.frontRightMecanumPort);
    rearRight = new WPI_TalonSRX(RobotMap.rearRightMecanumPort);
    mecanumDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    limitTalon(frontLeft);
    limitTalon(rearLeft);
    limitTalon(frontRight);
    limitTalon(rearRight);

    //mecanumDrive.setExpiration(0.2);
    mecanumDrive.setSafetyEnabled(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveRobot());
  }

  public void driveCartesian(double x, double y, double rotation){
    mecanumDrive.driveCartesian(x, y, rotation, 0.0);
  }

  private void limitTalon(WPI_TalonSRX talon){
    talon.configPeakCurrentLimit(0);
    talon.configPeakCurrentDuration(0);
    talon.configContinuousCurrentLimit(40);
    talon.enableCurrentLimit(true);
    talon.configOpenloopRamp(0.6);
    talon.setNeutralMode(NeutralMode.Brake);
  }

  
}
