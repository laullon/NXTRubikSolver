package com.laullon.NXT;

import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;

public class RubikSolver {

    public static void main(String[] args) {
        ColorSensor light = new ColorSensor(SensorPort.S1);
        NXTRegulatedMotor lightMotor = Motor.C;
        NXTRegulatedMotor tableMotor = Motor.A;
        NXTRegulatedMotor armMotor = Motor.B;

        reset(lightMotor);
        reset(tableMotor);
        reset(armMotor);

        lightMotor.setSpeed(90);
        tableMotor.setSpeed(180);

        lightMotor.rotate(170);

        armMotor.setSpeed(90);
        for (int i = 0; i < 3; i++) {
            armMotor.rotateTo(35);
            tableMotor.rotateTo(90 * (i + 1));
            armMotor.rotateTo(0);
            tableMotor.rotateTo(0);
        }

        lightMotor.rotate(-170);

        armMotor.setSpeed(180f);
        for (int i = 0; i < 3; i++) {
            armMotor.rotateTo(70);
            armMotor.rotateTo(0);
        }

//        tableMotor.rotate(180, true);
//
//        while (tableMotor.isMoving()) {
//            LCD.drawInt(light.getLightValue(), 4, 0, 0);
//            LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1);
//            LCD.drawInt(SensorPort.S1.readRawValue(), 4, 0, 2);
//            LCD.drawInt(SensorPort.S1.readValue(), 4, 0, 3);
//        }
//
//        tableMotor.rotate(-180);
        
        reset(lightMotor);
        reset(tableMotor);
        reset(armMotor);
    }

    private static void reset(NXTRegulatedMotor m) {
//        m.rotate(-360, true);
//        while (m.isMoving()) {
//            Thread.yield();
//        }
        m.resetTachoCount();
    }
}
