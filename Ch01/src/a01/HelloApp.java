package a01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/a01/beans.xml"));
		IMessageBean bean1 = factory.getBean("messageBean1", IMessageBean.class);
		bean1.sayHello("Spring");
		
		IMessageBean bean2 = factory.getBean("messageBean2", IMessageBean.class);
		bean2.sayHello("Spring");
	}

}
