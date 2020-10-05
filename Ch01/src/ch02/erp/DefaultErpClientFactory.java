package ch02.erp;

import java.util.Properties;

import ch06.xml.erp.ErpClient;
import ch06.xml.erp.ErpClientFactory;
import ch06.xml.erp.ErpOrderData;

public class DefaultErpClientFactory extends ErpClientFactory {
	private String server;
	public DefaultErpClientFactory(Properties props) {
		this.server = props.getProperty("server");
	}
	
	@Override
	public ErpClient create() {
		return new ErpClient() {
			@Override
			public void connect() {
				System.out.println("연결함:" + server);
			}
			public void close() {
				System.out.println("연결 끊음:" + server);
			}
			public void sendPurchaseInfo(ErpOrderData oi) {
				System.out.println("주문 정보 전송:" + server);
			}
		};
	}
}
