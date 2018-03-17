package br.tools;

public class ColorSensor extends java.lang.Thread{

	private int x;
	private boolean flag=true;
	private lejos.hardware.sensor.EV3ColorSensor cor1;
	
	public ColorSensor(){
		cor1 = new lejos.hardware.sensor.EV3ColorSensor(lejos.hardware.port.SensorPort.S3);
	}

	public void TurnOff(){
		flag=false;
	}
	public void run(){
		while(flag){
			x = cor1.getColorID();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	public int getColor(){
		return x;
	}
}
