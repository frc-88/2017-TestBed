package org.usfirst.frc.team88.robot.commands;

import org.usfirst.frc.team88.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StopShooter extends InstantCommand {

    public StopShooter() {
        super();
        requires(Robot.shooter);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.shooter.setShooter(0.0);
    }

}
