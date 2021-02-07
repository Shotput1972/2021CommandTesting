// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorControllers;

public class Hopper extends SubsystemBase {
  WPI_TalonSRX hopper = new WPI_TalonSRX (MotorControllers.HOPPER);
  /** Creates a new Hopper. */
  public Hopper() {
    hopper.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void hopperSpin (double speed) {
    hopper.set(speed);
  }
  public void stop() {
    hopper.set(0);
  }
}
