package ch06.xml.erp;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch06/xml/erp/config-erp.xml");
		ErpClientFactory factory = ctx.getBean("factory", ErpClientFactory.class);
		ErpClient client = factory.create();
		client.connect();
		client.close();
		ctx.close();
	}
}