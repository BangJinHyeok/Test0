package ch06.xml.erp;

public interface ErpClient {
	public void connect();
	public void close();
	public void sendPurchaseInfo(ErpOrderData oi);
}
