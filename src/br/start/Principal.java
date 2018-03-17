package br.start;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("INICIANDO...");
		
		br.tools.ColorSensor Cs = new br.tools.ColorSensor();
		
		Cs.start();

		lejos.hardware.sensor.EV3TouchSensor toq;
		toq = new lejos.hardware.sensor.EV3TouchSensor(lejos.hardware.port.SensorPort.S1);
		br.tools.SimpleTouch touch=new br.tools.SimpleTouch(toq);
		if(Cs.getColor()==3){		
			while (!touch.isPressed()) {
				System.out.println("DESTINO OK!!");
				System.out.println("Aperte o sensor de toque....\n");				
				lejos.utility.Delay.msDelay(1000);
			}
		}else{
			while (!touch.isPressed()) {
				System.out.println("NAO ENCONTREI");
				System.out.println(" O DESTINO!");
				System.out.println("Aperte o sensor de toque....\n");				
				lejos.utility.Delay.msDelay(1000);
			}
		}
		
		Cs.TurnOff();
		
	}

}