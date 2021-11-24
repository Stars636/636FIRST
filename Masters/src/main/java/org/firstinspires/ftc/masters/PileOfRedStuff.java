package org.firstinspires.ftc.masters;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Pile of red stuff")
public class PileOfRedStuff extends LinearOpMode {
    RobotClass robot;

    @Override
    public void runOpMode() {
        // Here Wayne will do stuff eventualy
        waitForStart();
        // Read the bar code with open CV


        robot.strafeLeft(0.5,2);
        robot.forward(0.3,0.6);
        //deposit shipping element.
        robot.strafeRight(0.3,2);
        robot.turnToHeading(0.3,90,3);
        robot.forward(0.3,4);
        robot.turnToHeading(0.3,0,3);
        robot.backwards(0.3,1);
        robot.forward(0.3,1);
        robot.turnToHeading(0.3,-90,3);
        robot.forward(0.5,4.6);
        robot.turnToHeading(0.3,0,3);
        // deposit shipping element
        robot.turnToHeading(0.3,90,3);
        robot.forward(0.3,4);
        robot.turnToHeading(0.3,0,3);
        robot.backwards(0.3,1);
        robot.forward(0.3,1);
        robot.turnToHeading(0.3,-90,3);
        robot.forward(0.5,4.6);
        robot.turnToHeading(0.3,0,3);

    }
}