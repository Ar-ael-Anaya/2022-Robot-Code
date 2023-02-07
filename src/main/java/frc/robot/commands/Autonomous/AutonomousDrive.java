// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutonomousDrive extends CommandBase {
  Timer m_timer = new Timer();
  double m_time;
  double m_xAxis;
  double m_yAxis;
  double m_zAxis;
 
  public AutonomousDrive(double time, double xAxis, double yAxis, double zAxis) {
    m_time = time;
    m_xAxis = xAxis;
    m_yAxis = yAxis;
    m_zAxis = zAxis;

    addRequirements(Robot.m_driveTrain);
  }


  @Override
  public void initialize() {
    //begins a timer when this command is first turned on
    m_timer.start();
    //Was negative last time Auto worked
    //Robot.m_driveTrain.setMotorSpeed(m_xAxis, m_yAxis, m_zAxis);
  }

  @Override
  public void execute() {
    //Was negative last time Auto worked
    //runs drivetrain at predetermined speed
    Robot.m_driveTrain.setMotorSpeed(m_xAxis, m_yAxis, m_zAxis,0);
  }


  @Override
  public void end(boolean interrupted) {}

  
  @Override
  public boolean isFinished() {

    //stops drivetrain if timer reaches a certain time.
    if (m_timer.hasElapsed(m_time)){
      Robot.m_driveTrain.setMotorSpeed(0 , 0, 0, 0);
      return true;
    }else{
    return false;
  }
 }
}
