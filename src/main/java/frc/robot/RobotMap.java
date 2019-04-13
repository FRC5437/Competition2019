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

  // Channels for pneumatics
  final public static int pneumaticsControlModulePrimaryNodeId = 0;
  final public static int solenoidShoulder = 1;
  final public static int solenoidElbow = 2;
  final public static int solenoidClaw = 3;
  final public static int solenoidRearStilts = 4;
  final public static int solenoidFrontStilts = 5;

  // Digital IO for sensors
  final public static int frontProximitySensor = 0;
  final public static int rearProximitySensor = 1;

  // Joystick constants
  final public static int leftStickXAxis = 0;
  final public static int leftStickYAxis = 1;
  final public static int rightStickXAxis = 4;

  // Limelight constants
  final public static int limelightPipelineDefault = 0;
  final public static int limelightPipelineTargetBasic = 1;
  final public static int limelightPipelineTarget3D = 4;

  // Climber motor controllers
  final public static int stiltDrivePort = 12;
  final public static int rearClimberMotorPort = 13;
  final public static int frontLeftClimberMotorPort = 14;
  final public static int frontRightClimberMotorPort = 15;

  // Elevator encoder config - TODO needs experimental adjustment
  final public static int lowHatch = 18000;
  final public static int midHatch = 66000;
  final public static int highHatch = 117000;
  final public static int cargoShipCargo = 20000;
  final public static int lowRocketCargo = 28000;
  final public static int midRocketCargo = 76000;
  final public static int highRocketCargo = 45000;
  

  // General TODO List
  // Tune elevator encoders
  // Tune Limelight 2 target interpolated setup
  // Set current limits on drive motors
}
