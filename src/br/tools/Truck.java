package br.tools;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

public class Truck {
	
	public void forward(int angle, int speed) {
		Motor.C.close();
		Motor.B.close();
		RegulatedMotor rmC = new EV3LargeRegulatedMotor(lejos.hardware.port.MotorPort.C);
		RegulatedMotor rmB = new EV3LargeRegulatedMotor(lejos.hardware.port.MotorPort.B);
		rmB.setSpeed(speed);
		rmC.setSpeed(speed);
		rmC.synchronizeWith(new RegulatedMotor[] { rmB });
		rmC.startSynchronization();
		rmC.rotate(angle, true);
		rmB.rotate(angle, true);
		rmC.endSynchronization();
		rmC.waitComplete();
		rmB.close();
		rmC.close();
	}
	
	public void stop() {
		Motor.C.close();
		Motor.B.close();
	}

}
