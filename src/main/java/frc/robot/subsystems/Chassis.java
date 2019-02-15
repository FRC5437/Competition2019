/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveRobot;

/**
 * Add your docs here.
 */
public class Chassis extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  AHRS ahrs;
  MecanumDrive myRobot;
  WPI_TalonSRX frontLeft;
  WPI_TalonSRX rearLeft;
  WPI_TalonSRX frontRight;
  WPI_TalonSRX rearRight;

  public Chassis(){
    frontLeft = new WPI_TalonSRX(RobotMap.frontLeftMecanumPort);
    rearLeft = new WPI_TalonSRX(RobotMap.rearLeftMecanumPort);
    frontRight = new WPI_TalonSRX(RobotMap.frontRightMecanumPort);
    rearRight = new WPI_TalonSRX(RobotMap.rearRightMecanumPort);
    myRobot = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    //smooth acceleration for open loop control
    frontLeft.configOpenloopRamp(0.5);
    frontRight.configOpenloopRamp(0.5);
    rearLeft.configOpenloopRamp(0.5);
    rearRight.configOpenloopRamp(0.5);

    frontLeft.setNeutralMode(NeutralMode.Brake);
    frontRight.setNeutralMode(NeutralMode.Brake);
    rearLeft.setNeutralMode(NeutralMode.Brake);
    rearRight.setNeutralMode(NeutralMode.Brake);

    myRobot.setExpiration(0.1);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveRobot());
  }

  //TODO determine if we are going to need gyroAngle in any scenario
  // it appears the x and y are documented backwards in wpi lib?
  public void driveCartesian(double x, double y, double rotation){
      myRobot.driveCartesian(x, y, rotation, 0.0);
  }
}
