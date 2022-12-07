//package org.firstinspires.ftc.masters.oldAndUselessStuff;
//
//import com.acmerobotics.roadrunner.geometry.Pose2d;
//import com.acmerobotics.roadrunner.geometry.Vector2d;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//import org.firstinspires.ftc.masters.MultipleCameraCV;
//import org.firstinspires.ftc.masters.drive.DriveConstants;
//import org.firstinspires.ftc.masters.drive.SampleMecanumDrive;
//import org.firstinspires.ftc.masters.FreightFrenzyConstants;
//import org.firstinspires.ftc.masters.trajectorySequence.TrajectorySequence;
//
//import java.util.Date;
//
//@Autonomous(name = "Red - Carousel (Park City) TWCA alt", group = "competition")
//public class RedCarouselOdoPanic extends LinearOpMode {
//
//    final int SERVO_DROP_PAUSE=700;
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//
//        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap, this, telemetry);
//
//        drive.openCVInnitShenanigans();
//
//        MultipleCameraCV.ShippingElementDeterminationPipeline.ElementPosition freightLocation = drive.analyze();
//
//        Pose2d startPose = new Pose2d(new Vector2d(-35, -63), Math.toRadians(90));
//
//        drive.setPoseEstimate(startPose);
//        drive.linearSlideServo.setPosition(org.firstinspires.ftc.masters.FreightFrenzyConstants.DUMP_SERVO_LIFT);
//
//        waitForStart();
//
//        long startTime = new Date().getTime();
//        long time = 0;
//
//        while (time < 200 && opModeIsActive()) {
//            time = new Date().getTime() - startTime;
//            freightLocation = drive.analyze();
//
//            telemetry.addData("Position", freightLocation);
//            telemetry.update();
//        }
//
//        drive.CV.webcam.stopStreaming();
//        switch (freightLocation) {
//            case LEFT:
//                drive.linearSlideMotor.setTargetPosition(org.firstinspires.ftc.masters.FreightFrenzyConstants.SLIDE_LOW);
//                break;
//            case MIDDLE:
//                drive.linearSlideMotor.setTargetPosition(org.firstinspires.ftc.masters.FreightFrenzyConstants.SLIDE_MIDDLE);
//                break;
//            case RIGHT:
//                drive.linearSlideMotor.setTargetPosition(org.firstinspires.ftc.masters.FreightFrenzyConstants.SLIDE_TOP);
//                break;
//            default:
//                drive.linearSlideMotor.setTargetPosition(org.firstinspires.ftc.masters.FreightFrenzyConstants.SLIDE_TOP);
//        }
//        drive.linearSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        drive.linearSlideMotor.setPower(.8);
//
//        if (isStopRequested()) return;
//
////      Deposit initial freight
//        Pose2d hubPosition = new Pose2d(new Vector2d(-30.5, -23), Math.toRadians(0));
//        TrajectorySequence toHub = drive.trajectorySequenceBuilder(startPose)
//                .lineToLinearHeading(hubPosition)
//                .build();
//        drive.followTrajectorySequence(toHub);
//
//        drive.linearSlideServo.setPosition(org.firstinspires.ftc.masters.FreightFrenzyConstants.DUMP_SERVO_DROP);
//        drive.pause(SERVO_DROP_PAUSE);
//        drive.linearSlideServo.setPosition(org.firstinspires.ftc.masters.FreightFrenzyConstants.DUMP_SERVO_BOTTOM);
//        if (freightLocation== MultipleCameraCV.ShippingElementDeterminationPipeline.ElementPosition.LEFT){
//            drive.pause(300);
//        }
//        drive.retract();
//
////        To spin duck
//        Pose2d position = drive.getLocalizer().getPoseEstimate();
//
//        TrajectorySequence toCarousel = drive.trajectorySequenceBuilder(position)
//                .lineToLinearHeading(new Pose2d(new Vector2d(-59, -59), Math.toRadians(90)))
//                .build();
//        drive.followTrajectorySequence(toCarousel);
//
//        drive.intakeMotor.setPower(0.8);
//        drive.jevilTurnRedCarousel(3); //can we go faster?
//
//
//
//        TrajectorySequence getOffCarousel = drive.trajectorySequenceBuilder(drive.getLocalizer().getPoseEstimate())
//                .strafeRight(2, SampleMecanumDrive.getVelocityConstraint(10, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH), SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))
//                .build();
//        drive.followTrajectorySequence(getOffCarousel);
//
//        drive.findDuckRed();
////
////        TrajectorySequence acquireDuck = drive.trajectorySequenceBuilder(drive.getLocalizer().getPoseEstimate())
////                .lineTo(new Vector2d(-55,-64))
////                .build();
////        drive.followTrajectorySequence(acquireDuck);
////
////        position = drive.getLocalizer().getPoseEstimate();
//
////        boolean hasDuck = drive
//
//        drive.pause(250);
//        drive.linearSlideServo.setPosition(org.firstinspires.ftc.masters.FreightFrenzyConstants.DUMP_SERVO_LIFT);
//        drive.pause(250);
//        drive.linearSlideMotor.setTargetPosition(org.firstinspires.ftc.masters.FreightFrenzyConstants.SLIDE_TOP);
//        drive.linearSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        drive.linearSlideMotor.setPower(.7);
//
//        position = drive.getLocalizer().getPoseEstimate();
//        TrajectorySequence trajSeq6 = drive.trajectorySequenceBuilder(position)
//                .lineToLinearHeading(hubPosition)
//                .build();
//        drive.followTrajectorySequence(trajSeq6);
//
//        drive.linearSlideServo.setPosition(org.firstinspires.ftc.masters.FreightFrenzyConstants.DUMP_SERVO_DROP);
//        drive.pause(SERVO_DROP_PAUSE);
//        drive.linearSlideServo.setPosition(FreightFrenzyConstants.DUMP_SERVO_BOTTOM);
//
//        drive.retract();
//
//        position = drive.getLocalizer().getPoseEstimate();
//        Pose2d parkPosition = new Pose2d(new Vector2d(-62, -35), Math.toRadians(0));
//        TrajectorySequence trajSeq7 = drive.trajectorySequenceBuilder(position)
//                .lineToLinearHeading(parkPosition)
//                .build();
//        drive.followTrajectorySequence(trajSeq7);
//
//    }
//
//
//}