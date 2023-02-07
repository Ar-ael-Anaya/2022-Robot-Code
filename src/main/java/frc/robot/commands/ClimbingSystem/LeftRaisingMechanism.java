// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClimbingSystem;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class LeftRaisingMechanism extends CommandBase {

  
  
  public LeftRaisingMechanism() {

   addRequirements(Robot.m_climber);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {

    //determnined value of left trigger AND multiplies it by limiting factor (making the actual value smaller)
    double leftTrigger = (Robot.m_robotContainer.GetDriverRawAxis(Constants.Controller.Joystick.m_leftTrigger)) * (Constants.m_limiter);
    
    //sets climber motor to value of left trigger
    Robot.m_climber.setLeftClimberMotorSpeed(leftTrigger);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  
    return false;
  }
 
}

