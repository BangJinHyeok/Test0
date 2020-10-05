package ch02.sensor;

import java.util.Map;

public class Monitor { //bean
	
	private Map<String, Sensor> sensorMap; // property(setter) - map - entry - key - ref(Sensor참조)
	private Map<String, Integer> config; // property(setter) - map - entry - key - value(integer)
	
	public void setSensorMap(Map<String, Sensor> sensorMap) {
		this.sensorMap = sensorMap;
	}
	
	public void setConfig(Map<String, Integer>config) { 
		this.config = config;
	}

	@Override
	public String toString() {
		return "Monitor [sensorMap=" + sensorMap + ", config=" + config + "]";
	}
	
	
}
