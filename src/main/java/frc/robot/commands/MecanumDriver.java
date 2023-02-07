// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;


public class MecanumDriver extends CommandBase {
  /** Creates a new MecanumDrive. */
  public MecanumDriver() {
    addRequirements(Robot.m_driveTrain);
  } 

  @Override
  public void initialize() {}

  @Override
  public void execute() {

    double leftStickX = (Robot.m_robotContainer.GetDriverRawAxis(Constants.Controller.Joystick.m_leftStickX)) * (Constants.m_limiter);
    double leftStickY = (Robot.m_robotContainer.GetDriverRawAxis(Constants.Controller.Joystick.m_leftStickY)) * (Constants.m_limiter);
    double leftStickZ = (Robot.m_robotContainer.GetDriverRawAxis(Constants.Controller.Joystick.m_rightStickX)) * (Constants.m_limiter);
    
    
 
    Robot.m_driveTrain.setMotorSpeed(leftStickX, leftStickY, leftStickZ, Robot.m_gyro.getGyroAngle());
    
  }

 
  @Override
  public void end(boolean interrupted) {
    
  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
 

}
