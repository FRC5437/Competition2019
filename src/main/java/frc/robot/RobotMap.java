/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // Channels for the wheels
  final public static int frontLeftMecanumPort	= 2;
  final public static int rearLeftMecanumPort	= 3;
  final public static int frontRightMecanumPort	= 1;
  final public static int rearRightMecanumPort	= 0;

  final public static int cargoVacuumPort = 7;
  final public static int hatchVacuumPort1 = 9;
  final public static int hatchVacuumPort2 = 10;

  final public static int elevatorPort = 11;
  final public static int stiltDrivePort = 12;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  final public static int pneumaticsControlModulePrimaryNodeId = 0;
  final public static int pneumaticsControlModuleSecondaryNodeId = 1;

  final public static int solenoidShoulderIn = 20;
  final public static int solenoidShoulderOut = 21;
  final public static int solenoidFirstElbowIn = 22;
  final public static int solenoidFirstElbowOut = 23;
  final public static int solenoidSecondElbowIn = 24;
  final public static int solenoidSecondElbowOut = 25;
  final public static int solenoidForwardStiltsUp = 26;
  final public static int solenoidForwardStiltsDown = 27;
  final public static int solenoidRearStiltsUp = 28;
  final public static int solenoidRearStiltsDown = 29;
  final public static int solenoidLeftVacuumOpen = 30;
  final public static int solenoidLeftVacuumClosed = 31;
  final public static int solenoidRightVacuumOpen = 32;
  final public static int solenoidRightVacuumClosed = 33;

  //TODO - setup any constants for gyro, ultrasonics, limit switches, and the elevator encoder

  final public static int leftStickXAxis = 0;
  final public static int leftStickYAxis = 1;
  final public static int rightStickXAxis = 4;

}
