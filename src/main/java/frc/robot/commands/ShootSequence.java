// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.MotorSpeeds;
import frc.robot.subsystems.ComboShooter;

public class ShootSequence extends CommandBase {
  private ComboShooter comboShooter;
  /** Creates a new ShootSequence. */
  public ShootSequence(ComboShooter cs) {
    comboShooter = cs;
    addRequirements(comboShooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    comboShooter.shootSequence(MotorSpeeds.ELEVATOR_SPEED, MotorSpeeds.SHOOTERSPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    comboShooter.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
