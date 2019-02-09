package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
  
  CANSparkMax spark1;
  CANSparkMax spark2;
  CANSparkMax spark3;
  CANSparkMax spark4;
  CANSparkMax spark5;
  CANSparkMax spark6;

  double leftspeed;
  double rightspeed;

public Drivetrain() {
  spark1 = new CANSparkMax(1, MotorType.kBrushless);
  spark1.setIdleMode(IdleMode.kCoast);
  spark2 = new CANSparkMax(2, MotorType.kBrushless);
  spark2.setIdleMode(IdleMode.kCoast);
  spark3 = new CANSparkMax(3, MotorType.kBrushless);
  spark3.setIdleMode(IdleMode.kCoast);
  spark4 = new CANSparkMax(4, MotorType.kBrushless);
  spark4.setIdleMode(IdleMode.kCoast);
  spark5 = new CANSparkMax(5, MotorType.kBrushless);
  spark5.setIdleMode(IdleMode.kCoast);
  spark6 = new CANSparkMax(6, MotorType.kBrushless);
  spark6.setIdleMode(IdleMode.kCoast);
}

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void arcadeDrive(double speed, double turn) {

    leftspeed = speed - turn;
    rightspeed = -speed - turn;

  }

  public void update() {
    
    spark1.set(leftspeed);
    spark2.set(leftspeed);
    spark3.set(leftspeed);
    spark4.set(rightspeed);
    spark5.set(rightspeed);
    spark6.set(rightspeed);

  }
}
