// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {

  private final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  private final NetworkTableEntry pipeline = table.getEntry("pipeline");
  private final NetworkTableEntry xOffset = table.getEntry("tx");
  private final NetworkTableEntry yOffset = table.getEntry("ty");

  private int currentPipeline = 0;
  
  @Override
  public void periodic() {
    table.getEntry("ledMode").setNumber(3);
      }
  
  public void togglezoom(){
    if(currentPipeline == 0)
        currentPipeline = 1;
    else if(currentPipeline ==1)
        currentPipeline = 0;
  }

  public double getXOffset(){
    return xOffset.getDouble(0);
  }

  public double getYOffset(){
    return yOffset.getDouble(0);
  }

  public void setPipeline(int id){
    pipeline.setNumber(id);
  }
}
