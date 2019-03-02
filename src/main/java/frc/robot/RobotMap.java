package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // Channels for the TalonSRX motor controllers
  final public static int rearLeftMecanumPort	= 1;
  final public static int frontLeftMecanumPort	= 2;
  final public static int frontRightMecanumPort	= 3;
  final public static int rearRightMecanumPort	= 4;
  final public static int elevatorPort = 55;
  final public static int elevatorSlavePort = 54;
  final public static int stiltDrivePort = 12;

  // Channels for pneumatics
  final public static int pneumaticsControlModulePrimaryNodeId = 0;
  final public static int solenoidBrake = 0;
  final public static int solenoidShoulder = 1;
  final public static int solenoidElbow = 2;
  final public static int solenoidClaw = 3;
  final public static int solenoidForwardStilts = 4;
  final public static int solenoidRearStilts = 5;

  // Digital IO for sensors
  final public static int frontProximitySensor = 0;
  final public static int rearProximitySensor = 1;

  // Joystick constants
  final public static int leftStickXAxis = 0;
  final public static int leftStickYAxis = 1;
  final public static int rightStickXAxis = 4;

}
