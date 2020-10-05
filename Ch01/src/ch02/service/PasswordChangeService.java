package ch02.service;

public class PasswordChangeService { //bean
	
	private UserRepository userRepository;
	
	public PasswordChangeService(UserRepository userRepository) { //xml에서 생성자 : constructor-arg
		this.userRepository = userRepository;
	}
	
	public void changePassword(String userId, String oldPw, String newPw) { //실행 메서드 : xml에서 x
		User user = userRepository.findUserById(userId);
		if (user == null)
			throw new UserNotFoundException();
		
		user.changePassword(oldPw, newPw);
	}
}
