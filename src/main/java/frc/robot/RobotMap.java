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
  final public static int rearRightMecanumPort	= 4;

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

  final public static int solenoidShoulder = 0;
  final public static int solenoidElbow = 1;
  final public static int solenoidForwardStilts = 2;
  final public static int solenoidRearStilts = 3;
  final public static int solenoidLeftVacuum = 4;
  final public static int solenoidRightVacuum = 5;
  final public static int solenoidCargoVacuum = 6;

  //TODO - setup any constants for gyro, ultrasonics, limit switches, and the elevator encoder

  final public static int leftStickXAxis = 0;
  final public static int leftStickYAxis = 1;
  final public static int rightStickXAxis = 4;

}
