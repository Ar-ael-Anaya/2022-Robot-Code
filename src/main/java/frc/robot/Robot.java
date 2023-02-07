// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.MecanumDriver;
import frc.robot.commands.IntakeShooterSystem.Shooter;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.GyroSubsystem;
import frc.robot.subsystems.IntakeShooter;


public class Robot extends TimedRobot {
 
 //Establishing instances of nessesarry classes 

 public static MecanumDrive m_robotDrive;

 public static GyroSubsystem m_gyro = new GyroSubsystem();
 public static DriveTrain m_driveTrain = new DriveTrain();

 public static IntakeShooter m_intakeShooter = new IntakeShooter();
 
 public static Shooter  m_intake = new Shooter();

 public static Climber m_climber = new Climber();

 public static Arm m_arm = new Arm();

 public static MecanumDriver m_mecanumDriver = new MecanumDriver();

 private Command m_autonomousCommand;
  
 public static RobotContainer m_robotContainer = new RobotContainer();
  
 
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
  //establishes intance of robot container, resets gyro, and starts camera stream all when robot is turned on
    m_robotContainer = new RobotContainer();
    
    Robot.m_gyro.gyroCalibrate();
    
    CameraServer.startAutomaticCapture();
  }
 
  @Override
  public void robotPeriodic() {
  
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {

    //establishes instance of autonomous command
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {

      //runs selected autonomous sequence
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    //cancels auto when teleop begins
    CommandScheduler.getInstance().cancelAll();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    

  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
