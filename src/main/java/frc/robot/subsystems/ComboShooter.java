// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorControllers;

public class ComboShooter extends SubsystemBase {
  CANSparkMax leftshooter, rightshooter;
  WPI_VictorSPX elevator1, elevator2;
  SpeedControllerGroup elevatorGroup;
  /** Creates a new ComboShooter. */
  public ComboShooter() {
elevator1 = new WPI_VictorSPX(MotorControllers.ELEVATOR_1);
elevator2 = new WPI_VictorSPX(MotorControllers.ELEVATOR_2);
elevatorGroup = new SpeedControllerGroup(elevator1, elevator2);
elevator2.setInverted(true);
leftshooter = new CANSparkMax(MotorControllers.LEFTSHOOTER,MotorType.kBrushless);
rightshooter = new CANSparkMax(MotorControllers.RIGHTSHOOTER,MotorType.kBrushed);
rightshooter.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void shootSequence (double elevatorspeed, double shooterspeed){
    leftshooter.set(shooterspeed);
    rightshooter.set(shooterspeed);
    elevator1.set(elevatorspeed);
    elevator2.set(elevatorspeed);
  }
  public void stop(){
    leftshooter.set(0);
    rightshooter.set(0);
    elevator1.set(0);
    elevator2.set(0);
  }
}
