package ch07.xml.search;

import org.springframework.beans.factory.FactoryBean;

public class SearchClientFactoryBean implements FactoryBean<SearchClientFactory>{
	private String server;
	private int port;
	private String contentType;
	private String encoding = "utf8";
	private SearchClientFactory searchClientFactory;
	
	public void setServer(String server) { //xml value : 10.20.30.40
		this.server = server;
	}
	
	public void setPort(int port) { //xml value : 8888
		this.port = port;
	}
	
	public void setContentType(String contentType) { //xml value : json
		this.contentType = contentType;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	//Override 메소드는 2개
	@Override
	public SearchClientFactory getObject() throws Exception { //getObjectType(getObject()) 메소드는 구현한 클래스를 반환해주는 메소드
		if (this.searchClientFactory != null)
			return this.searchClientFactory;
		SearchClientFactoryBuilder builder = new SearchClientFactoryBuilder();
		builder.server(server)
				.port(port)
				.contentType(contentType == null ? "json" : contentType)
				.encoding(encoding);
		SearchClientFactory searchClientFactory = builder.build();
		searchClientFactory.init(); //HttpSearchClientFactory.init() 메서드 실행 
		this.searchClientFactory = searchClientFactory;
		return this.searchClientFactory;
	}
	
	@Override
	public Class<?> getObjectType() {
		//getObject()에서 리턴되는 객체의 타입을 명시
		return SearchClientFactory.class;
	}
	public boolean isSingleton() {
		//isSingletone 메소드는 생성되는 객체를 싱글톤(한개의 객체)로만 설정할 것인가를 정하는설정 메소드입니다. true면 주소값을 계속 재사용하며 false면 매번 재생성
		return true;
	}
}
