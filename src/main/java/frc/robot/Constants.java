// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
//This entire file is simply meant to provide a single storage Unit for each variable, its all pretty self explanatory 
public final class Constants {
 public class Motors{     
   
    public  class DriveMotors{
         // values change depending on wiring
        public static final int m_frontleft = 0;
        public static final int m_rearleft = 1;
        public static final int m_frontRight = 2;
        public static final int m_rearRight = 3;

   }

   public class ClimberMotors{
        // values change depending on wiring
       public static final int m_leftClimber = 6;
       public static final int m_rightClimber = 7;
   }

    public final class IntakeShooterMotors{
         // values change depending on wiring
        public static final int m_intakeShooterMotor = 4;
  }

    public class ArmMotors{
         // values change depending on wiring
        public static final int m_armMotor = 5;
 }
}
    public static final class MotorSpeeds{


    public static class IntakeShooterValues {
        
        public static double m_intakeMotorSpeed = 1;
        public static double m_shooterMotorSpeed = -1;
   }
    public static class Climbervalues {
        //invert negative depending on motor orientation
        public static double m_leftMotorSpeed = .5;
        public static double m_rightMotorSpeed = .5;
  }
    public static class ArmValues{
        //invert negative depending on motor orientation
        //Request Way to dettach chain to test without breaking bot
        public static double m_armRaisingMotorSpeed = -.15;
        public static double m_armLoweringMotorSpeed = .15;
    }
    public final class AutonomousValues{
       
        public static final double m_xAutoZero = 0;
        public static final double m_yAutoZero = 0;
        public static final double m_yAutoNegOne = -1;
        public static final double m_yAutoPosOne = 1;
        public static final double m_zAutoZero = 0;
        public static final double m_zAutoPosOne = 1;
        
 }
}
  
 
      
   public final class Controller{

        public static final int m_controller = 0;
    
        public final class Buttons{
            public static final int m_aButton = 1;
            public static final int m_bButton = 2;
            public static final int m_xButton = 3;
            public static final int m_yButton = 4;
           
            

            public final class Bumpers{
                public static final int m_lBumper = 5;
                public static final int m_rBumper = 6;
                
    }
   }
        public final class Joystick{

            public static final int m_leftStickX = 0;
            public static final int m_leftStickY = 1;
            public static final int m_rightStickX = 4;

          
            public static final int m_leftTrigger = 2; 
            public static final int m_rightTrigger = 3; 
          //public static final int m_rightStickY = 5;
  
 }
}
    public final class Timings{
        public final class AutonomousTimings{
            //Adjust depending on competition rules
            public static final double m_autonomousTimeOneSeconds = 1;
            public static final double m_autonomousTimeTwoSeconds = 2;
            public static final double m_autonomousTimeThreeSeconds = 3;
            public static final double m_autonomousTimeTenSeconds = 10;
         
        }

        public final class ClimberTimings{
            //Adjust based on testing and Speed choosen 
            public static final double m_ClimberRaisingTime = 5;
            public static final double m_ClimberloweringTime = 5;
        }

        public final class ArmTimings{
            //Adjust based on testing and Speed choosen
            public static final double m_ArmLoweringTime = 1.5;
            public static final double m_ArmRaisingTime = 1.5;
        }

       
    }  

    public static final double m_limiter = 1;
}

