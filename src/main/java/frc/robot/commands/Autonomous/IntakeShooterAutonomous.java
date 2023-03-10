// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IntakeShooterAutonomous extends CommandBase {
  /** Creates a new ShooterAutonomous. */
  //begins a timer, a time, and a speed variable
  Timer m_timer = new Timer();
  double m_time;
  double m_speed;
  public IntakeShooterAutonomous(double time, double speed) {
    //sets time and speed variables equal to preset values
    m_time = time;
    m_speed = speed;

    addRequirements(Robot.m_intakeShooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //begins timer function
    m_timer.start();
    addRequirements(Robot.m_intakeShooter);
   //Removed setting Motor Speed at Start
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //sets intake motor to predetermined speed
    Robot.m_intakeShooter.setIntakeShooterMotorSpeed(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //stops shooter if timer reaches a certain time.
    if (m_timer.hasElapsed(m_time)){
     m_timer.reset();
      Robot.m_intakeShooter.setIntakeShooterMotorSpeed(0);
      return true;
    }else{
 }
    return false;
  }
}
