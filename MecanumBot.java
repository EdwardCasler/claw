package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumBot {
    private String frName;
    private String flName;
    private String brName;
    private String blName;

    private DcMotor fr;
    private DcMotor fl;
    private DcMotor br;
    private DcMotor bl;

    HardwareMap hw;

    private boolean hasSetMotorNames = false;
    private boolean hasInit = false;
    public void SetMotorNames(String frontRight, String frontLeft, String backRight, String backLeft) {
        frName = frontRight;
        flName = frontLeft;
        brName = backRight;
        blName = backLeft;

        hasSetMotorNames = true;
    }
    public void Init(HardwareMap hardwareMap, Gamepad gamepad) {
        if(!hasSetMotorNames) { throw new IllegalStateException("You must set the motor names before calling Init."); }

        hw = hardwareMap;

        fr = hardwareMap.get(DcMotor.class, frName);
        fl = hardwareMap.get(DcMotor.class, flName);
        br = hardwareMap.get(DcMotor.class, brName);
        bl = hardwareMap.get(DcMotor.class, blName);

        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        hasInit = true;
    }
    public void Drive(Gamepad gp) {
        if(!hasInit || !hasSetMotorNames) { throw new IllegalStateException("You have to Init and set motor names first"); }

        float forward = -gp.left_stick_y;
        float strafe = gp.left_stick_x;
        float rotate = gp.right_stick_x;

        double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(rotate), 1);

        fl.setPower((forward + strafe + rotate) / denominator);
        fr.setPower((forward - strafe - rotate) / denominator);
        bl.setPower((forward - strafe + rotate) / denominator);
        br.setPower((forward + strafe - rotate) / denominator);
    }
}