package ch08.anno.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import ch02.service.AuthFailLogger;
import ch02.service.AuthenticationService;
import ch02.service.PasswordChangeService;
import ch02.service.UserRepository;

public class ConfigUser1 {
	
	@Autowired //다른 컨테이너의 메서드를 가져와 쓸 수 있도록 해주는 기능
	private UserRepository userRepository;
	
	@Bean
	 public PasswordChangeService pwChangeSvc() {
		return new PasswordChangeService(userRepository);
	}	
	
	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}

	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authSvc = new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		authSvc.setUserRepository(userRepository);
		return authSvc;
	}
}
