// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorControllers;

public class Shooter extends SubsystemBase {
  CANSparkMax leftshooter, rightshooter;

  /** Creates a new Shooter. */
  public Shooter() {
    leftshooter = new CANSparkMax(MotorControllers.LEFTSHOOTER, MotorType.kBrushless);
    rightshooter = new CANSparkMax(MotorControllers.RIGHTSHOOTER, MotorType.kBrushless);
    rightshooter.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void shootBall(double speed){
    leftshooter.set(speed);
    rightshooter.set(speed);
  }

  public void stop(){
    leftshooter.set(0);
    rightshooter.set(0);
  }

}
