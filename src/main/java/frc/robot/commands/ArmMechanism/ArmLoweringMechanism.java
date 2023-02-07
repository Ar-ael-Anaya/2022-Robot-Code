// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ArmMechanism;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ArmLoweringMechanism extends CommandBase {
  Timer m_timer = new Timer();
  double m_time; 


  public ArmLoweringMechanism(double time) {
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
      Robot.m_arm.setArmMotorSpeed(Constants.MotorSpeeds.ArmValues.m_armLoweringMotorSpeed);
      if (! Robot.m_robotContainer.xButton.getAsBoolean() || Robot.m_arm.checkBottomArmLimitSwitch()){
        Robot.m_arm.setArmMotorSpeed(0);
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //sets arm to predetermined speed
    Robot.m_arm.setArmMotorSpeed(0);
    m_timer.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {   
    //returns false if timer is greater than time, ending command, better version of older autonomous timer finish?
    return m_timer.get() > m_time;
 }
}
