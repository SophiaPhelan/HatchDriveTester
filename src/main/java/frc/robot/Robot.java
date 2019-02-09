package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  Joystick rightJoystick;
  Joystick leftJoystick;

  Drivetrain drivetrain;
  HatchIntake hatch;

  AnalogInput analog;

  public void robotInit() {

    rightJoystick = new Joystick(1);
    leftJoystick = new Joystick(0);

    drivetrain = new Drivetrain();
    hatch = new HatchIntake();

    analog = new AnalogInput(0);
    

  }

  public void robotPeriodic() {
  }

  public void autonomousInit() {
  }

  public void autonomousPeriodic() {
  }

  public void teleopPeriodic() {

    double speed = Math.pow(leftJoystick.getRawAxis(1),3);
    double turn = Math.pow(rightJoystick.getRawAxis(0),3);
    drivetrain.arcadeDrive(speed, turn);
    if ( leftJoystick.getRawButton(1) ) {
      hatch.pushOut();
    }
    if ( rightJoystick.getRawButton(1) ) {
      hatch.hEject();
    } else if ( rightJoystick.getRawButton(2) ) {
      hatch.hLock();
    }

    DriverStation.reportError("" + analog.getValue(), false);

    drivetrain.update();
    hatch.update();
  }

  public void testPeriodic() {
  }
}
