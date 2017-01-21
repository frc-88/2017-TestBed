package org.usfirst.frc.team88.robot.commands;

import org.usfirst.frc.team88.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StartShooter extends InstantCommand {
	private Preferences prefs;
	
	public StartShooter() {
        super();
        requires(Robot.shooter);

    }

    // Called once when the command executes
    protected void initialize() {
    	prefs = Preferences.getInstance();

    	double speed = prefs.getDouble("shooterSpeed", 0.0);

		Robot.shooter.setShooter(speed);
    }

}
