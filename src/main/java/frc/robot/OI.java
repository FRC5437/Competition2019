/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.CloseClaw;
import frc.robot.commands.ExtendElbow;
import frc.robot.commands.ExtendShoulder;
import frc.robot.commands.OpenClaw;
import frc.robot.commands.RetractElbow;
import frc.robot.commands.RetractShoulder;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  final static int xboxDriveControllerPort = 1;
  final static int xboxOperatorControllerPort = 2;
  
  XboxController xboxDrive = new XboxController(xboxDriveControllerPort);
  XboxController xboxOperator = new XboxController(xboxOperatorControllerPort);

  public JoystickButton xButton = new JoystickButton(xboxDrive, 3);
	public JoystickButton yButton = new JoystickButton(xboxDrive, 4);
	public JoystickButton aButton = new JoystickButton(xboxDrive, 1);
	public JoystickButton bButton = new JoystickButton(xboxDrive, 2);
	public JoystickButton rightBumper = new JoystickButton(xboxDrive, 6);
	public JoystickButton leftBumper = new JoystickButton(xboxDrive, 5);
	public JoystickButton startButton = new JoystickButton(xboxDrive, 8);
	public JoystickButton selectButton = new JoystickButton(xboxDrive, 7);
	public JoystickButton leftStickButton = new JoystickButton(xboxDrive, 9);
	public JoystickButton rightStickButton = new JoystickButton(xboxDrive, 10);

  public OI(){
    xButton.whenPressed(new CloseClaw());
    yButton.whenPressed(new OpenClaw());
    aButton.whenPressed(new ExtendElbow());
    bButton.whenPressed(new RetractElbow());
    rightBumper.whenPressed(new ExtendShoulder());
    leftBumper.whenPressed(new RetractShoulder());
  }

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public XboxController getXboxDrive(){
    return xboxDrive;
  }
}
