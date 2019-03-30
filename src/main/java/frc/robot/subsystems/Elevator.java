package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.AdjustElevator;

/**
 * Add your docs here.
 */
public class Elevator extends PIDSubsystem {
  WPI_TalonSRX elevatorMotor;
  WPI_TalonSRX elevatorSlaveMotor;
  final static double kP = 0.4;
	final static double kI = 0.0;
  final static double kD = 0.0;

  int targetPosition;

  public Elevator(){
    super("Elevator", kP, kI, kD);
    elevatorMotor = new WPI_TalonSRX(RobotMap.elevatorPort);
    elevatorMotor.setSafetyEnabled(false);
		elevatorMotor.setNeutralMode(NeutralMode.Brake);
		elevatorMotor.configOpenloopRamp(0.2, 0);
		elevatorMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 10, 10);
		elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    
    /* configure this to ensure sensor is positive when output is positive */
    elevatorMotor.setSensorPhase(true);
    elevatorMotor.setSelectedSensorPosition(0);
    elevatorMotor.configAllowableClosedloopError(0, 300, 10);
    
    elevatorSlaveMotor = new WPI_TalonSRX(RobotMap.elevatorSlavePort);
    elevatorSlaveMotor.follow(elevatorMotor);
    setAbsoluteTolerance(500.0);
  }

  @Override
	protected double returnPIDInput() {
		return elevatorMotor.getSelectedSensorPosition(0);
  }
  
  @Override
  protected void usePIDOutput(double output) {
    elevatorMotor.set(ControlMode.PercentOutput, output);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new AdjustElevator());
  }

  public void adjustElevator(double speed){
    //TODO - adjust speed for up vs down differences
    elevatorMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setElevatorToPosition(int encoderTicks){
    elevatorMotor.set(ControlMode.Position, encoderTicks);
  }

  public void resetEncoder(){
    elevatorMotor.setSelectedSensorPosition(0);
  }

  public void stopElevator(){
    elevatorMotor.set(ControlMode.PercentOutput, 0.0);
  }

  //TODO - add specific height targets for elevator positioning
  // such as rocket hatch low/mid/high and rocket cargo low/med/high
  public int getEncoderPosition(){
    return elevatorMotor.getSelectedSensorPosition();
  }

}
