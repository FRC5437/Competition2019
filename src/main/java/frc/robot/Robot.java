package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.*;
import frc.robot.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Climber m_climber = new Climber();
  public static Chassis m_chassis = new Chassis();
  public static Elevator m_elevator = new Elevator();
  public static Claw m_claw = new Claw();
  public static OI m_oi;

  //setup pneumatics
  Compressor compressor = new Compressor(RobotMap.pneumaticsControlModulePrimaryNodeId);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    compressor.setClosedLoopControl(true);
    m_oi = new OI();

    // set the limelight for driver viewing in sandstorm
    setLimelightPipeline(RobotMap.limelightPipelineDefault);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    updateMetrics();
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  public static void setLimelightPipeline(int pipelineIndex){
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(pipelineIndex);
  }

  private void updateMetrics() {
	  //NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
    //double[] camtran = limelightTable.getEntry("camtran").getDoubleArray(new double[6]);
    //NetworkTableInstance.getDefault().getTable("RBB").getEntry("Yaw").setNumber(camtran[4]);
    //NetworkTableInstance.getDefault().getTable("RBB").getEntry("3Dx").setNumber(camtran[0]);
    //NetworkTableInstance.getDefault().getTable("RBB").getEntry("3Dy").setNumber(camtran[1]);
    //NetworkTableInstance.getDefault().getTable("RBB").getEntry("3Dz").setNumber(camtran[2]);
    NetworkTable rbb = NetworkTableInstance.getDefault().getTable("RBB");
    rbb.getEntry("Elevator Position").setNumber(m_elevator.getEncoderPosition());
    rbb.getEntry("Match Time").setNumber(Timer.getMatchTime());
  }
}
