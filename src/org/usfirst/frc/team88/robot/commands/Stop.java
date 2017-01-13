package org.usfirst.frc.team88.robot.commands;

import org.usfirst.frc.team88.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Stop extends InstantCommand {

    public Stop() {
        super();
        requires(Robot.shooter);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.shooter.set(0.0);
    }

}
