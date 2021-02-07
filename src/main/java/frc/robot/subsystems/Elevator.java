// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorControllers;

public class Elevator extends SubsystemBase {
  WPI_VictorSPX elevator1 = new WPI_VictorSPX(MotorControllers.ELEVATOR_1);
  WPI_VictorSPX elevator2 = new WPI_VictorSPX(MotorControllers.ELEVATOR_2);
  SpeedControllerGroup elevatorGroup = new SpeedControllerGroup(elevator1, elevator2);
  /** Creates a new Elevator. */
  public Elevator() {
    elevator2.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void elevateBall(double speed) {
    elevatorGroup.set(speed);
  }
  public void lowerBall(double speed) {
    elevatorGroup.set(speed);
  }
  public void stop() {
    elevatorGroup.set(0);
  }
}
