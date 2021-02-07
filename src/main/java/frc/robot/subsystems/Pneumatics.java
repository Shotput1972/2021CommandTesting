// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants.PneumaticConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  /** Creates a new Pneumatics. */
            private final DoubleSolenoid m_hatchSolenoid =
          new DoubleSolenoid(
              PneumaticConstants.IntakeSolenoidModule,
              PneumaticConstants.IntakeSolenoidPorts[0],
              PneumaticConstants.IntakeSolenoidPorts[1]);
    
      /** Grabs the hatch. */
      public void grabHatch() {
        m_hatchSolenoid.set(kForward);
      }
  
      /** Releases the hatch. */
      public void retractHatch() {
        m_hatchSolenoid.set(kReverse);
      }
    
    
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
