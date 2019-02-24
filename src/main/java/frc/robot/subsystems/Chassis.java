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
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
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
  AHRS ahrs;
  MecanumDrive myRobot;
  WPI_TalonSRX frontLeft;
  WPI_TalonSRX rearLeft;
  WPI_TalonSRX frontRight;
  WPI_TalonSRX rearRight;
  WPI_TalonSRX stiltDrive;
  Solenoid forwardStilts;
  Solenoid rearStilts;
  DigitalInput frontProximitySensor;
  DigitalInput rearProximitySensor;

  // Subsystems are created as soon as the robot program starts - move any initialization that needs to wait
  // for robot init or the activation of a game mode into new public methods to be invoked from the robot object
  // at that time.
  public Chassis(){
    frontProximitySensor = new DigitalInput(RobotMap.frontProximitySensor);
    rearProximitySensor = new DigitalInput(RobotMap.rearProximitySensor);

    forwardStilts = new Solenoid(RobotMap.pneumaticsControlModulePrimaryNodeId, RobotMap.solenoidForwardStilts);
    rearStilts = new Solenoid(RobotMap.pneumaticsControlModulePrimaryNodeId, RobotMap.solenoidRearStilts);
    stiltDrive = new WPI_TalonSRX(RobotMap.stiltDrivePort);

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

  // TODO determine if we are going to need gyroAngle in any scenario
  // it appears the x and y are documented backwards in wpi lib?
  public void driveCartesian(double x, double y, double rotation){
      myRobot.driveCartesian(x, y, rotation, 0.0);
  }

  public void driveOntoHab3(){
    // elevate stilts and check ultrasonics for expected range (more than a foot)
    forwardStilts.set(true);
    rearStilts.set(true);
    while (!frontProximitySensor.get() && !rearProximitySensor.get()){
      // creep forward
      stiltDrive.set(ControlMode.PercentOutput, 0.5);
    }
    // when front down facing ultrasonic shows platform stop creeping and raise front stilts
    stiltDrive.set(ControlMode.PercentOutput, 0.0);
    if (frontProximitySensor.get()){
      forwardStilts.set(false);
    }
    // drive forward slowly
    
    // when rear down facing ultrasonic shows platform stop driving and raise rear stilts
    // drive forward a little more and activate light show ;)
  }
}
