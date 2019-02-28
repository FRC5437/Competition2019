package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StraightenArm extends CommandGroup {
  /**
   * Add your docs here.
   */
  public StraightenArm() {
    addParallel(new RetractShoulder());
    addParallel(new ExtendElbow());
  }
}
