package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.ShooterData;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
	private CANTalon shooterTalon;
	
	public Shooter () {
		shooterTalon = new CANTalon(RobotMap.shooter);
		/*
		shooterTalon.setPID(P, I, D);
		shooterTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		shooterTalon.configEncoderCodesPerRev(360);
		shooterTalon.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterTalon.configPeakOutputVoltage(+12.0f, -12.0f);
		shooterTalon.reverseSensor(false);
		shooterTalon.reverseOutput(false);
		shooterTalon.enableBrakeMode(false);
		*/
	}

	public void set(double target) {
		shooterTalon.set(target);
		

	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ShooterData());
    }
	
	public void displayData(){
		SmartDashboard.putNumber("Current",shooterTalon.getOutputCurrent());
		SmartDashboard.putNumber("Voltage",shooterTalon.getOutputVoltage());
		SmartDashboard.putNumber("EncVelocity",shooterTalon.getEncVelocity());
		SmartDashboard.putNumber("Speed",shooterTalon.getSpeed());
		SmartDashboard.putNumber("SetPoint",shooterTalon.getSetpoint());
		SmartDashboard.putNumber("Error",shooterTalon.getError());
		SmartDashboard.putNumber("Position",shooterTalon.getPosition());
	}
}

