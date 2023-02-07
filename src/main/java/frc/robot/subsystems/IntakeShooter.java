// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class IntakeShooter extends SubsystemBase {

  //establishes intake motor
 PWMVictorSPX intakeShooterMotor = new PWMVictorSPX(Constants.Motors.IntakeShooterMotors.m_intakeShooterMotor);
 
  public IntakeShooter() {}

  @Override
  public void periodic() {
  }

  //command to set intake motor to selected axis value
  public void setIntakeShooterMotorSpeed(double axis){
    intakeShooterMotor.set(axis);
    }
  

}

