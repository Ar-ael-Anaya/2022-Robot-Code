// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.MecanumDriver;
import frc.robot.commands.ArmMechanism.ArmLoweringMechanism;
import frc.robot.commands.ArmMechanism.ArmRaisingMechanism;

import frc.robot.commands.ClimbingSystem.LeftLoweringMechanism;
import frc.robot.commands.ClimbingSystem.LeftRaisingMechanism;
import frc.robot.commands.Gyro.ResetGyro;
import frc.robot.commands.IntakeShooterSystem.Shooter;
import frc.robot.commands.IntakeShooterSystem.Intake;



public class RobotContainer {
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();
//establishes instance of controller and all corresponding buttons
  XboxController controller = new XboxController(Constants.Controller.m_controller);

  public Trigger xButton = new JoystickButton(controller, Constants.Controller.Buttons.m_xButton);
  public Trigger yButton = new JoystickButton(controller, Constants.Controller.Buttons.m_yButton);
  public Trigger bButton = new JoystickButton(controller, Constants.Controller.Buttons.m_bButton);
  public Trigger aButton = new JoystickButton(controller, Constants.Controller.Buttons.m_aButton);

  public Trigger rBumper = new JoystickButton(controller, Constants.Controller.Buttons.Bumpers.m_rBumper);
  public Trigger lBumper = new JoystickButton(controller, Constants.Controller.Buttons.Bumpers.m_lBumper);


  //function to gather value of joystick axis

  public double GetDriverRawAxis(int axis){
    return controller.getRawAxis(axis);
  }

  private void configureButtonBindings() {

    //establishes default commands for subsystems
    Robot.m_driveTrain.setDefaultCommand(new MecanumDriver());
    Robot.m_intakeShooter.setDefaultCommand(new Shooter());
    Robot.m_climber.setDefaultCommand(new LeftRaisingMechanism());
   //Robot.m_arm.setDefaultCommand(new ArmLoweringMechanism(Constants.Timings.ArmTimings.m_ArmRaisingTime));

//displays dashboard drop down allowing the selection of different autonomous sequences

    m_chooser.setDefaultOption("Auto Sequence 1", new frc.robot.commands.Autonomous.AutonomousSequences.AutonomousSequenceOne());
    m_chooser.addOption("Auto Sequence 2", new frc.robot.commands.Autonomous.AutonomousSequences.AutonomousSequenceTwo());
    SmartDashboard.putData(m_chooser);
  }

  public RobotContainer() {

    //correlates a button being pressed or held to command occuring
    xButton.onTrue(new ArmLoweringMechanism(Constants.Timings.ArmTimings.m_ArmLoweringTime));
    bButton.onTrue(new ArmRaisingMechanism(Constants.Timings.ArmTimings.m_ArmRaisingTime));
    yButton.onTrue(new ResetGyro());

   rBumper.whileTrue(new Intake());
    lBumper.whileTrue(new LeftLoweringMechanism());
   
  
   
 
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
 
  public Command getAutonomousCommand() {
    //An ExampleCommand will run in autonomous
    //runs selected autonomous sequence
    return m_chooser.getSelected();
  }
  
}
