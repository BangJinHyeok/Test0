package a02;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean {
	
	private String name;
	private String greeting;
	
	private Outputter outputter;
	//constuctor injection (생성자에 값을 주는 방식)
	public MessageBeanImpl(String name) {
		this.name = name;
	}
	
	//setter injection (세터에 값을 주는 방식)
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	public void sayHello() {
		String message = greeting + name + "!";
		System.out.println(message);
		
		try {
			outputter.output(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}