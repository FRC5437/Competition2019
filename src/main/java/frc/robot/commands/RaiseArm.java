package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RaiseArm extends CommandGroup {
  /**
   * Add your docs here.
   */
  public RaiseArm() {
    addParallel(new ExtendElbow());
    addParallel(new ExtendShoulder());
  }
}
