package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Finch {
    enum MovementType {
            FORWARD,
            BACKWARDS,
            STRAFE_LEFT,
            STRAFE_RIGHT,
            TURN_LEFT,
            TURN_RIGHT,
    } 
    public static DcMotorEx topLeft;;
    public static DcMotorEx topRight;;
    public static DcMotorEx bottomLeft;
    public static DcMotorEx bottomRight;
    public static IMU imu;
    static double ticksPerRotation = 537.6;
    static double wheelCircumference = 11.8737122661;
    static double inchesPerTick = ticksPerRotation/wheelCircumference;
        
    public static double inchesToTicks(double inches) {
        double ticksMoved = inches * inchesPerTick;
        return ticksMoved;
    }
    public static void moveInches(double inches, double speed, MovementType movementType) {
        switch(movementType) {
            case FORWARD:
                while(true) {
                    if(topLeft.getCurrentPosition() >= inchesToTicks(-inches) && topRight.getCurrentPosition() <= inchesToTicks(inches)) {
                        topLeft.setPower(-speed);
                        topRight.setPower(speed);
                        bottomLeft.setPower(-speed);
                        bottomRight.setPower(speed);
                    }
                    else if(topLeft.getCurrentPosition() <= inchesToTicks(-inches) && topRight.getCurrentPosition() >= inchesToTicks(inches)) {
                        topLeft.setPower(0);
                        topRight.setPower(0);
                        bottomLeft.setPower(0);
                        bottomRight.setPower(0);
                        break;
                    }
                }
                topLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                topRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                bottomLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                bottomRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                topLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                topRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                bottomLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                bottomRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                break;
            case BACKWARDS:
                while(true) {
                    if(topLeft.getCurrentPosition() <= inchesToTicks(inches) && topRight.getCurrentPosition() >= inchesToTicks(-inches)) {
                        topLeft.setPower(speed);
                        topRight.setPower(-speed);
                        bottomLeft.setPower(speed);
                        bottomRight.setPower(-speed);
                    }
                    else if(topLeft.getCurrentPosition() >= inchesToTicks(inches) && topRight.getCurrentPosition() <= inchesToTicks(-inches)) {
                        topLeft.setPower(0);
                        topRight.setPower(0);
                        bottomLeft.setPower(0);
                        bottomRight.setPower(0);
                        break;
                    }
                }
                topLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                topRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                bottomLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                bottomRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                topLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                topRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                bottomLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                bottomRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                break;
            case STRAFE_LEFT:
                while(true) {
                    if(topLeft.getCurrentPosition() <= inchesToTicks(inches) && topRight.getCurrentPosition() <= inchesToTicks(inches)) {
                        topLeft.setPower(speed);
                        topRight.setPower(speed);
                        bottomLeft.setPower(-speed);
                        bottomRight.setPower(-speed);
                    }
                    else if(topLeft.getCurrentPosition() >= inchesToTicks(inches) && topRight.getCurrentPosition() >= inchesToTicks(inches)) {
                        topLeft.setPower(0);
                        topRight.setPower(0);
                        bottomLeft.setPower(0);
                        bottomRight.setPower(0);
                        break;
                    }
                }
                topLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                topRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                bottomLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                bottomRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                topLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                topRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                bottomLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                bottomRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                break;
            case STRAFE_RIGHT:
                while(true) {
                    if(topLeft.getCurrentPosition() >= inchesToTicks(-inches) && topRight.getCurrentPosition() >= inchesToTicks(-inches)) {
                        topLeft.setPower(-speed);
                        topRight.setPower(-speed);
                        bottomLeft.setPower(speed);
                        bottomRight.setPower(speed);
                    }
                    else if(topLeft.getCurrentPosition() <= inchesToTicks(-inches) && topRight.getCurrentPosition() <= inchesToTicks(-inches)) {
                        topLeft.setPower(0);
                        topRight.setPower(0);
                        bottomLeft.setPower(0);
                        bottomRight.setPower(0);
                        break;
                    }
                }
                topLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                topRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                bottomLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                bottomRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                topLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                topRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                bottomLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                bottomRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                break;
            }
        }
        public static void rotateDegrees(double degrees, double speed, MovementType movementType){
            switch(movementType) {
                case TURN_LEFT:
                    while(true) {
                        if(!(imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES) > degrees)) {
                            topLeft.setPower(speed);
                            topRight.setPower(speed);
                            bottomLeft.setPower(speed);
                            bottomRight.setPower(speed);
                        }
                        else {
                            topLeft.setPower(0);
                            topRight.setPower(0);
                            bottomLeft.setPower(0);
                            bottomRight.setPower(0);
                            break;
                        }
                    }
                    topLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                    topRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                    bottomLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                    bottomRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                    topLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                    topRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                    bottomLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                    bottomRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                    imu.resetYaw();
                    break;
                case TURN_RIGHT:
                    while(true) {
                        if(!(imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES) < -degrees)) {
                            topLeft.setPower(-speed);
                            topRight.setPower(-speed);
                            bottomLeft.setPower(-speed);
                            bottomRight.setPower(-speed);
                        }
                        else {
                            topLeft.setPower(0);
                            topRight.setPower(0);
                            bottomLeft.setPower(0);
                            bottomRight.setPower(0);
                            break;
                        }
                    }
                    topLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                    topRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                    bottomLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                    bottomRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                    topLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                    topRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                    bottomLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                    bottomRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                    imu.resetYaw();
                    break;
            }
        }
}