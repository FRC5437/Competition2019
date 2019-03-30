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
public class Climber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX frontLeftMotor;
  WPI_TalonSRX rearMotor;
  WPI_TalonSRX frontRightMotor;
  WPI_TalonSRX stiltDrive;

  public Climber(){
    frontLeftMotor = new WPI_TalonSRX(RobotMap.frontLeftClimberMotorPort);
    rearMotor = new WPI_TalonSRX(RobotMap.rearClimberMotorPort);
    frontRightMotor = new WPI_TalonSRX(RobotMap.frontRightClimberMotorPort);
    stiltDrive = new WPI_TalonSRX(RobotMap.stiltDrivePort);

    limitTalon(frontLeftMotor);
    limitTalon(rearMotor);
    limitTalon(frontRightMotor);
    limitTalon(stiltDrive);

    /* configure this to ensure sensor is positive when output is positive */
    frontLeftMotor.setSensorPhase(true);
    frontLeftMotor.setSelectedSensorPosition(0);
    frontLeftMotor.configAllowableClosedloopError(0, 300, 10);

    /* configure this to ensure sensor is positive when output is positive */
    frontRightMotor.setSensorPhase(true);
    frontRightMotor.setSelectedSensorPosition(0);
    frontRightMotor.configAllowableClosedloopError(0, 300, 10);

    /* configure this to ensure sensor is positive when output is positive */
    rearMotor.setSensorPhase(true);
    rearMotor.setSelectedSensorPosition(0);
    rearMotor.configAllowableClosedloopError(0, 300, 10);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void stopAllClimbers(){
    frontRightMotor.set(ControlMode.PercentOutput, 0.0);
    frontLeftMotor.set(ControlMode.PercentOutput, 0.0);
    rearMotor.set(ControlMode.PercentOutput, 0.0);
    stiltDrive.set(ControlMode.PercentOutput, 0.0);
  }

  public void raiseStilts(){
    // forwardStilts.set(true);
   //  rearStilts.set(true);
   }
 
  public void raiseFrontRight(){
    frontRightMotor.set(ControlMode.PercentOutput, 0.50);
  }

  public void raiseFrontLeft(){
    frontLeftMotor.set(ControlMode.PercentOutput, 0.50);
  }
 
   public void raiseRear(){
    rearMotor.set(ControlMode.PercentOutput, 0.50);
   }
 
   public void drive(double speed){
      stiltDrive.set(ControlMode.PercentOutput, speed);
   }
 
   public void lowerFrontRight(){
    frontRightMotor.set(ControlMode.PercentOutput, -0.50);
  }

  public void lowerFrontLeft(){
    frontLeftMotor.set(ControlMode.PercentOutput, -0.50);
  }
 
   public void lowerRear(){
    rearMotor.set(ControlMode.PercentOutput, -0.50);
   }
 
   public boolean getFrontProximitySensor(){
     //return frontProximitySensor.get();
     return false;
   }
 
   public boolean getRearProximitySensor(){
     //return rearProximitySensor.get();
     return false;
   }
 
   public void driveOntoHab3(){
     // elevate stilts and check ultrasonics for expected range (more than a foot)
     //forwardStilts.set(true);
     //rearStilts.set(true);
     //if (!frontProximitySensor.get() && !rearProximitySensor.get()){
       // creep forward
       //stiltDrive.set(ControlMode.PercentOutput, 0.5);
     //}
 
     // wait for the front proximity sensor to fire
     //while(!frontProximitySensor.get()){
       // keep driving
     //}
     // when front down facing ultrasonic shows platform stop creeping and raise front stilts
     //stiltDrive.set(ControlMode.PercentOutput, 0.0);
     //forwardStilts.set(false);
     
     //verify the state of the world is like we expect - front is on and rear is off
     //if (frontProximitySensor.get() && !rearProximitySensor.get()){
       // creep forward
       //stiltDrive.set(ControlMode.PercentOutput, 0.5);
     //}
 
     // drive forward slowly until rear proximity sensor fires
     //while(!rearProximitySensor.get()){
       // keep driving
     //}
     
     // when rear down facing ultrasonic shows platform stop driving and raise rear stilts
     //stiltDrive.set(ControlMode.PercentOutput, 0.0);
     //rearStilts.set(false);
 
     // drive forward a little more and activate light show ;)
     //mecanumDrive.drivePolar(0.4, 0.0, 0.0);
     //Timer.delay(0.5);
     //mecanumDrive.drivePolar(0.0, 0.0, 0.0);
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
