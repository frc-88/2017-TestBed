package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.ShooterData;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
	private double p = 0.0;
	private double i = 0.0;
	private double d = 0.0;
	private double f = 0.0;

	private CANTalon shooterTalon;
	private Preferences prefs;

	public Shooter() {
		prefs = Preferences.getInstance();
		shooterTalon = new CANTalon(RobotMap.shooter);

		if (prefs.getBoolean("closed", false)) {
			updatePID();
			shooterTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
			shooterTalon.configEncoderCodesPerRev(80);
			shooterTalon.configNominalOutputVoltage(+0.0f, -0.0f);
			shooterTalon.configPeakOutputVoltage(+12.0f, -12.0f);
			shooterTalon.reverseSensor(false);
			shooterTalon.reverseOutput(false);
			shooterTalon.enableBrakeMode(false);
		}
	}

	public void set(double target) {
		shooterTalon.set(target);
	}

	public void updatePID() {
		p = prefs.getDouble("shooterP", 0.0);
		i = prefs.getDouble("shooterI", 0.0);
		d = prefs.getDouble("shooterD", 0.0);
		f = prefs.getDouble("shooterF", 0.0);

		shooterTalon.setPID(p, i, d, f, 0, 0, 0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ShooterData());
	}

	public void displayData() {
		SmartDashboard.putNumber("Current", shooterTalon.getOutputCurrent());
		SmartDashboard.putNumber("Voltage", shooterTalon.getOutputVoltage());
		SmartDashboard.putNumber("EncVelocity", shooterTalon.getEncVelocity());
		SmartDashboard.putNumber("Speed", shooterTalon.getSpeed());
		SmartDashboard.putNumber("SetPoint", shooterTalon.getSetpoint());
		SmartDashboard.putNumber("Error", shooterTalon.getError());
		SmartDashboard.putNumber("Position", shooterTalon.getPosition());
	}
}
