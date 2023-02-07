// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.AutonomousSequences;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.Autonomous.AutonomousDrive;
import frc.robot.commands.Autonomous.IntakeShooterAutonomous;


public class AutonomousSequenceOne extends SequentialCommandGroup {
  /** Creates a new AutonomousSequence. */
  public AutonomousSequenceOne() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    new AutonomousDrive(Constants.Timings.AutonomousTimings.m_autonomousTimeOneSeconds, Constants.MotorSpeeds.AutonomousValues.m_xAutoZero,
      Constants.MotorSpeeds.AutonomousValues.m_yAutoPosOne, Constants.MotorSpeeds.AutonomousValues.m_zAutoZero),


    new IntakeShooterAutonomous( Constants.Timings.AutonomousTimings.m_autonomousTimeTwoSeconds, Constants.MotorSpeeds.IntakeShooterValues.m_shooterMotorSpeed), 
      
    new AutonomousDrive(
      Constants.Timings.AutonomousTimings.m_autonomousTimeThreeSeconds,Constants.MotorSpeeds.AutonomousValues.m_xAutoZero ,
      Constants.MotorSpeeds.AutonomousValues.m_yAutoNegOne , Constants.MotorSpeeds.AutonomousValues.m_zAutoZero) 
    
      
     );
  }
}
