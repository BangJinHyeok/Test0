package a01;

public class MessageBeanEn implements IMessageBean { //상속 받음
	
	public void sayHello(String name) {
		System.out.println("Hello, " + name + "!");
	}
	
}