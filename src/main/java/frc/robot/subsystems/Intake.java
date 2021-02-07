// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorControllers;

public class Intake extends SubsystemBase {
  CANSparkMax intake;
  /** Creates a new Intake. */
  public Intake() {
    intake = new CANSparkMax(MotorControllers.INTAKE, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void intakeBall(double speed) {
    intake.set(speed);
  }
  public void stop() {
    intake.set(0);
  }
}
