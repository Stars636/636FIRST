package org.firstinspires.ftc.teamcode.opmodes.AutonomousOpmodes.Blue;

import static org.firstinspires.ftc.teamcode.autoutils.CompTrajectoryGenerator.trajectories.BLUE_BOTTOM;
import static org.firstinspires.ftc.teamcode.autoutils.CompTrajectoryGenerator.trajectories.BLUE_TOP;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.autoutils.CompTrajectoryGenerator;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.util.Other.DynamicTypeValue;
import org.firstinspires.ftc.teamcode.util.RobotHardwareInitializer;

import java.util.HashMap;

@Autonomous(name = "Blue Top - Park Left - ROBOT FACES LEFT", group = "Blue", preselectTeleOp = "RealestDriverOpMode")
public class TopParkLeft extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        HashMap<RobotHardwareInitializer.Other, DynamicTypeValue> otherSystems =
                RobotHardwareInitializer.initializeAllOtherSystems(this);

        final CompTrajectoryGenerator CTG = new CompTrajectoryGenerator(drive,
                otherSystems, true);

        waitForStart();

        CTG.setStartingPosition(BLUE_TOP);

        drive.followTrajectorySequence(CTG.BLUE_TOP);
        CTG.placePixelOnBoard();

        drive.setPoseEstimate(CTG.BLUE_TOP.end());
        drive.followTrajectorySequence(CTG.BLUE_TOP_PARK);
    }
}