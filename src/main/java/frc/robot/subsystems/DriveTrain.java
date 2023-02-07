// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
//import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class DriveTrain extends SubsystemBase {
  
  //establishes  each drivetrain motor
  private PWMSparkMax frontLeft = new PWMSparkMax(Constants.Motors.DriveMotors.m_frontleft);
  private PWMSparkMax reafLeft = new PWMSparkMax(Constants.Motors.DriveMotors.m_rearleft);
  private PWMSparkMax frontRight = new PWMSparkMax(Constants.Motors.DriveMotors.m_frontRight);
  private PWMSparkMax rearRight = new PWMSparkMax(Constants.Motors.DriveMotors.m_rearRight);
  


  /** Creates a new DriveTrain. */
  public DriveTrain() {

    //inverts select drive train  motors
    rearRight.setInverted(true);
    frontRight.setInverted(true);

//establishes robotdrive as a mecanum drive command using the 4 drivetrain motors

    Robot.m_robotDrive = new MecanumDrive(frontLeft, reafLeft, frontRight, rearRight);

  }

  @Override
  public void periodic() {}

//creates function that sets drivetrain to certain speeds bases on joystick inputs

  public void setMotorSpeed(double xAxis, double yAxis, double  zAxis, double d){
    Robot.m_robotDrive.driveCartesian(xAxis, yAxis, zAxis);
  } 
}
