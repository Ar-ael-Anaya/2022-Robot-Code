// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.AutonomousSequences;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.Autonomous.ArmAutonomous;
import frc.robot.commands.Autonomous.AutonomousDrive;
import frc.robot.commands.Autonomous.IntakeShooterAutonomous;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousSequenceTwo extends SequentialCommandGroup {
  /** Creates a new AutonomousSequenceTwo. */
  public AutonomousSequenceTwo() {
    addCommands(
    //drive forward while intaking
    new ParallelRaceGroup(

      new AutonomousDrive(Constants.Timings.AutonomousTimings.m_autonomousTimeThreeSeconds, 
      Constants.MotorSpeeds.AutonomousValues.m_xAutoZero,Constants.MotorSpeeds.AutonomousValues.m_yAutoPosOne,
      Constants.MotorSpeeds.AutonomousValues.m_zAutoZero)

    ,
    
    new IntakeShooterAutonomous( Constants.Timings.AutonomousTimings.m_autonomousTimeThreeSeconds, 
    Constants.MotorSpeeds.IntakeShooterValues.m_intakeMotorSpeed)

    )
    ,
      //rotate 180 degrees
      new AutonomousDrive(Constants.Timings.AutonomousTimings.m_autonomousTimeTwoSeconds,
      Constants.MotorSpeeds.AutonomousValues.m_xAutoZero, Constants.MotorSpeeds.AutonomousValues.m_yAutoZero, 
      Constants.MotorSpeeds.AutonomousValues.m_zAutoPosOne )
      ,

      //Raise Arm
      new ArmAutonomous(Constants.Timings.AutonomousTimings.m_autonomousTimeTwoSeconds,
       Constants.MotorSpeeds.ArmValues.m_armRaisingMotorSpeed)

      ,

      //Drive Forward
      new AutonomousDrive(Constants.Timings.AutonomousTimings.m_autonomousTimeThreeSeconds,
       Constants.MotorSpeeds.AutonomousValues.m_xAutoZero,
      Constants.MotorSpeeds.AutonomousValues.m_yAutoPosOne, Constants.MotorSpeeds.AutonomousValues.m_zAutoZero)
      
      ,

      new IntakeShooterAutonomous(Constants.Timings.AutonomousTimings.m_autonomousTimeTwoSeconds, 
      Constants.MotorSpeeds.IntakeShooterValues.m_intakeMotorSpeed)

      ,

      new AutonomousDrive(
        Constants.Timings.AutonomousTimings.m_autonomousTimeThreeSeconds,Constants.MotorSpeeds.AutonomousValues.m_xAutoZero ,
        Constants.MotorSpeeds.AutonomousValues.m_yAutoNegOne , Constants.MotorSpeeds.AutonomousValues.m_zAutoZero) 




    );
  }
}
