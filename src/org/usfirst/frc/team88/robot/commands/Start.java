package org.usfirst.frc.team88.robot.commands;

import org.usfirst.frc.team88.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Start extends InstantCommand {
	private Preferences prefs;
	
	public Start() {
        super();
        requires(Robot.shooter);

    	prefs = Preferences.getInstance();
    }

    // Called once when the command executes
    protected void initialize() {
    	double speed = prefs.getDouble("speed", 0.0);
    	
		Robot.shooter.set(speed);
    }

}
