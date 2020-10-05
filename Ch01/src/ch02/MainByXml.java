package ch02;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch02.service.AuthException;
import ch02.service.AuthenticationService;
import ch02.service.PasswordChangeService;
import ch02.service.User;
import ch02.service.UserNotFoundException;
import ch02.service.UserRepository;

public class MainByXml {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch02/config.xml");
		UserRepository ur = ctx.getBean("userRepository", UserRepository.class);
		User u = ur.findUserById("bkchoi");
		System.out.println(u);
		
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1111");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "11111");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "111111");
		try {
			authSvc.authenticate("bkchoi2", "1111");
		} catch (UserNotFoundException ex) {
			
		}
		authSvc.authenticate("bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678"); //changePassword : 사용자가 자신의 웹 사이트 암호를 변경할 수 있는 사용자 인터페이스를 제공
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1234");
		authSvc.authenticate("bkchoi", "5678"); //아이디 비밀번호 확인
		
		ctx.close();
	}
	
	private static void runAuthAndCatchAuthEx(AuthenticationService authSvc, String userId, String password) {
		try {
			authSvc.authenticate(userId, password);
		} catch (AuthException ex) {
			
		}
	}

}