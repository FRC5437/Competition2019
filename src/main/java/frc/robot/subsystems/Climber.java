/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  Solenoid rearStiltSolenoid;
  Solenoid frontStiltSolenoid;

  public Climber(){
    rearStiltSolenoid = new Solenoid(RobotMap.solenoidRearStilts);
    frontStiltSolenoid = new Solenoid(RobotMap.solenoidFrontStilts);
  }

  public void initialize(){
    rearStiltSolenoid.set(false);
    frontStiltSolenoid.set(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
 
   public void raiseRear(){
      rearStiltSolenoid.set(true);
   }
 
   public void lowerRear(){
    rearStiltSolenoid.set(false);
   }

   public void raiseFront(){
    frontStiltSolenoid.set(true);
   }

    public void lowerFront(){
      frontStiltSolenoid.set(false);
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
     
   }
}
