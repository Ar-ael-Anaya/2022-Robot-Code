// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeShooterSystem;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Shooter extends CommandBase {

  public Shooter() {
    
    addRequirements(Robot.m_intakeShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //returns value of right trigger
    double rightTrigger = (Robot.m_robotContainer.GetDriverRawAxis(Constants.Controller.Joystick.m_rightTrigger));
//sets shooter motor speed to the inverse value of the right trigger (see negative)
    Robot.m_intakeShooter.setIntakeShooterMotorSpeed(-rightTrigger);
   

   
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
