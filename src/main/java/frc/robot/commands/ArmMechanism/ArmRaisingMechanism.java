// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ArmMechanism;
//Implement Dio switch backup

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ArmRaisingMechanism extends CommandBase {
  Timer m_timer = new Timer();
  double m_time; 
  public ArmRaisingMechanism(double time) {
    m_time = time;
    addRequirements(Robot.m_arm);
  }


  @Override
  public void initialize() {

      m_timer.start();
   
  }

  @Override
  public void execute() {
    //sets motor speed to certain value, if button not pressed or limit switch pressed stops it
    Robot.m_arm.setArmMotorSpeed(Constants.MotorSpeeds.ArmValues.m_armRaisingMotorSpeed );
    if (! Robot.m_robotContainer.bButton.getAsBoolean() || Robot.m_arm.checkTopArmLimitSwitch()){
      Robot.m_arm.setArmMotorSpeed(0);
    }  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_arm.setArmMotorSpeed(0);
    m_timer.reset();
 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
 
    return m_timer.get() > m_time;
 }
}
