// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.DriverJoystick;
import frc.robot.Constants.OPSCONTROL;
import frc.robot.commands.AlignTurret;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.ElevateBall;
import frc.robot.commands.GrabHatch;
import frc.robot.commands.HopperSpin;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.LowerBall;
import frc.robot.commands.MoveElevator;
import frc.robot.commands.RetractHatch;
import frc.robot.commands.ShootBall;
import frc.robot.commands.TurretLeft;
import frc.robot.commands.TurretRight;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.commands.ComboIntake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain;
  private final DriveWithJoysticks driveWithJoysticks;
  private final DriveForwardTimed driveForwardTimed;
  public static Joystick driverJoystick, opsControl;
  private final Shooter shooter;
  private final ShootBall shootBall;
  private final Elevator elevator;
  private final ElevateBall elevateBall;
  private final MoveElevator moveElevator;
  private final LowerBall lowerBall;
  private final Intake intake;
  private final IntakeBall intakeBall;
  private final Hopper hopper;
  private final HopperSpin hopperSpin;
  private final Turret turret;
  private final TurretRight turretRight;
  private final TurretLeft turretLeft;
  private final Pneumatics pneumatics;
  private final GrabHatch grabHatch;
  private final AlignTurret alignTurret;
  private final Limelight limelight;
  private final ComboIntake comboIntake;
  private final RetractHatch retractHatch;
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveTrain = new DriveTrain();
    driveWithJoysticks = new DriveWithJoysticks(driveTrain);
    driveWithJoysticks.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoysticks);
    driveForwardTimed = new DriveForwardTimed(driveTrain);
    driveForwardTimed.addRequirements(driveTrain);

    driverJoystick = new Joystick(DriverJoystick.DriverStick);
    opsControl = new Joystick(OPSCONTROL.OPSControl);

    shooter = new Shooter();
    shootBall = new ShootBall(shooter);
    shootBall.addRequirements(shooter);

    elevator = new Elevator();
    moveElevator = new MoveElevator(elevator);
    elevator.setDefaultCommand(moveElevator);
    elevateBall = new ElevateBall(elevator);
    elevateBall.addRequirements(elevator);
    lowerBall = new LowerBall(elevator);
    lowerBall.addRequirements(elevator);
    

    intake = new Intake();
    intakeBall = new IntakeBall(intake);
    intakeBall.addRequirements(intake);

    hopper = new Hopper();
    hopperSpin = new HopperSpin(hopper);
    hopperSpin.addRequirements(hopper);

    limelight = new Limelight();
    turret = new Turret();
    turretRight = new TurretRight(turret);
    turretRight.addRequirements(turret);
    turretLeft = new TurretLeft(turret);
    turretLeft.addRequirements(turret);
    alignTurret = new AlignTurret(turret, limelight);
    alignTurret.addRequirements(turret, limelight);
        
    pneumatics = new Pneumatics();
    grabHatch = new GrabHatch(pneumatics);
    grabHatch.addRequirements(pneumatics);
    retractHatch = new RetractHatch(pneumatics);
    retractHatch.addRequirements(pneumatics);

    comboIntake = new ComboIntake(pneumatics, intake);
    comboIntake.addRequirements(pneumatics, intake);

    
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Driver Button Bindings
    JoystickButton intakeButton = new JoystickButton(driverJoystick, DriverJoystick.LT_BUMPER);
    intakeButton.whileHeld(new IntakeBall(intake));
    JoystickButton hopperButton = new JoystickButton(driverJoystick, DriverJoystick.RT_BUMPER);
    hopperButton.whileHeld(new HopperSpin(hopper));
    JoystickButton extendIntakeButton = new JoystickButton(driverJoystick, DriverJoystick.Y_BUTTON);
    extendIntakeButton.whenPressed(new GrabHatch(pneumatics));
    JoystickButton retractIntakeButton = new JoystickButton(driverJoystick, DriverJoystick.A_BUTTON);
    retractIntakeButton.whenPressed(new RetractHatch(pneumatics));
    JoystickButton comboIntakeButton = new JoystickButton(driverJoystick, DriverJoystick.X_BUTTON);
    comboIntakeButton.whileHeld(new ComboIntake(pneumatics,intake));
    JoystickButton releaseIntakeButton = new JoystickButton(driverJoystick, DriverJoystick.X_BUTTON);
    releaseIntakeButton.whenReleased(new RetractHatch(pneumatics));


    //Operator Button Bindings
    JoystickButton shootButton = new JoystickButton(opsControl, OPSCONTROL.RT_BUMPER);
    shootButton.whileHeld(new ShootBall(shooter));
    JoystickButton elevateBallButton = new JoystickButton(opsControl, OPSCONTROL.Y_BUTTON);
    elevateBallButton.whileHeld(new ElevateBall(elevator));
    JoystickButton lowerBallButton = new JoystickButton(opsControl, OPSCONTROL.A_BUTTON);
    lowerBallButton.whileHeld(new LowerBall(elevator));
    JoystickButton turretRightButton1 = new JoystickButton(opsControl, OPSCONTROL.B_BUTTON);
    turretRightButton1.whileHeld(new TurretRight(turret));
    JoystickButton turretLeftButton1 = new JoystickButton(opsControl, OPSCONTROL.X_BUTTON);
    turretLeftButton1.whileHeld(new TurretLeft(turret));
    JoystickButton alignTurretButton = new JoystickButton(opsControl, OPSCONTROL.LT_BUMPER);
    alignTurretButton.whileHeld(new AlignTurret(turret, limelight));
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveForwardTimed;
  }
}
