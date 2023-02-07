// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  DigitalInput topArmlimitSwitch = new DigitalInput(0);
  DigitalInput bottomArmlimitSwitch = new DigitalInput(1);
  PWMVictorSPX armMotor = new PWMVictorSPX(Constants.Motors.ArmMotors.m_armMotor);
 

  public Arm() {}

  @Override
  public void periodic() {

  }

//creates function that sets drivetrain to certain speeds bases on joystick inputs

public void setArmMotorSpeed(double axis){
  armMotor.set(axis);
 
}

public boolean checkTopArmLimitSwitch(){
  return  topArmlimitSwitch.get();
}
public boolean checkBottomArmLimitSwitch(){
  return  bottomArmlimitSwitch.get();
}

}
