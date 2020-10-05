package a01;

public class MessageBeanKr implements IMessageBean { //상속 받음
	
	public void sayHello(String name) {
		System.out.println("안녕하세요, " + name + "!");
	}
	
}