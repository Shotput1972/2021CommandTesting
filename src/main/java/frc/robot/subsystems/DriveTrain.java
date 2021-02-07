// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriverJoystick;
import frc.robot.Constants.MotorControllers;

public class DriveTrain extends SubsystemBase {
  WPI_TalonFX leftFront;
  WPI_TalonFX leftRear;
  WPI_TalonFX rightFront;
  WPI_TalonFX rightRear;
  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;
  DifferentialDrive drive;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftFront = new WPI_TalonFX(MotorControllers.LEFT_FRONT);
    leftFront.setInverted(false);
    leftRear = new WPI_TalonFX(MotorControllers.LEFT_REAR);
    leftRear.setInverted(false);
    rightFront = new WPI_TalonFX(MotorControllers.RIGHT_FRONT);
    rightFront.setInverted(false);
    rightRear = new WPI_TalonFX(MotorControllers.RIGHT_REAR);
    rightRear.setInverted(false);
     
    leftMotors = new SpeedControllerGroup(leftFront, leftRear);
    rightMotors = new SpeedControllerGroup(rightFront, rightRear);
    drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoysticks(Joystick joystick,double speed)
  {
    drive.arcadeDrive(joystick.getRawAxis(DriverJoystick.LEFT_Y_AXIS)*speed, 
    joystick.getRawAxis(DriverJoystick.LEFT_X_AXIS)*.625*speed);
  }

  public void driveForward(double speed)
  {
    drive.tankDrive(speed, speed);
  }

  public void stop()
  {
    drive.stopMotor();
  }
}
