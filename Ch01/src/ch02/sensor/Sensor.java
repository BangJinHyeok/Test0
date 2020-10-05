package ch02.sensor;

import java.util.Properties;
import java.util.Set;

public class Sensor {
	private Properties additionaInfo; //bean - property - props - prop 
	private Set<String> agentCodes; //bean - set - value(String)
	
	public void setAdditionalInfo(Properties additionalInfo) { //setter
		this.additionaInfo = additionaInfo;
	}
	
	public void setAgentCodes(Set<String> agentCodes) { //setter
		this.agentCodes = agentCodes;
	}
	
	public int read() {
		return 0;
	}

	@Override
	public String toString() {
		return "Sensor [additionaInfo=" + additionaInfo + ", agentCodes=" + agentCodes + "]";
	}
	
}
