// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.MotorSpeeds;
import frc.robot.subsystems.Intake;

public class IntakeBall extends CommandBase {
  private Intake intake;
  Timer timer;
  /** Creates a new IntakeBall. */
  public IntakeBall(Intake i) {
    intake = i;
    addRequirements(intake);
    timer = new Timer();

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    timer.reset();
    timer.start();
    while(timer.get()>AutoConstants.INTAKEDELAY);
    {
      intake.intakeBall(MotorSpeeds.INTAKESPEED);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
