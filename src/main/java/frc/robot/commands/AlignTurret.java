// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.MotorSpeeds;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;

public class AlignTurret extends CommandBase {

  private final Turret turret;
  private final Limelight limelight;

    private boolean useTDM = false;
    private int tdmCount = 0;
    private int tdmThreshold = 100;

  /** Creates a new AlignTurret. */
  
  public AlignTurret(Turret turret, Limelight limelight){
    this(turret,limelight,false);
  }

  public AlignTurret(Turret turret, Limelight limelight, boolean useTDM){
    this.turret = turret;
    this.limelight = limelight;
    this.useTDM = useTDM;
  
    addRequirements(turret, limelight);
  }  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = (limelight.getXOffset()+2)* MotorSpeeds.TURRETSPEED;

    if (speed>.2)
        speed = .2;
    else if (speed <-.2)
        speed = -.2;

  turret.setRotatorSpeed(speed);
  
  tdmCount++;
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    turret.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
