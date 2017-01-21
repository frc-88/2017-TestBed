package org.usfirst.frc.team88.robot.commands;

import org.usfirst.frc.team88.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StartIndexer extends InstantCommand {
	private Preferences prefs;
	
	public StartIndexer() {
        super();
        requires(Robot.shooter);

    }

    // Called once when the command executes
    protected void initialize() {
    	prefs = Preferences.getInstance();

    	double speed = prefs.getDouble("indexerSpeed", 0.0);

		Robot.shooter.setIndexer(speed);
    }

}
