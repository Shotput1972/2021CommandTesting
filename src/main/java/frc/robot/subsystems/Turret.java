// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorControllers;

public class Turret extends SubsystemBase {
  WPI_TalonSRX turret = new WPI_TalonSRX(MotorControllers.TURRET);
  /** Creates a new Turret. */
  public Turret() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void turretLeft(double speed) {
    turret.set(speed);
  }
  public void turretRight(double speed) {
    turret.set(speed);
  }
  public void setRotatorSpeed (double speed) {
    turret.set(ControlMode.PercentOutput, speed);
  }
  public void stop() {
    turret.set(0);
  }
}
