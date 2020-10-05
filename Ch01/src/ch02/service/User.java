package ch02.service;

public class User {
	private String id;
	private String password;
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + "]";
	}
	
	public boolean matchPassword(String inputPasswd) {
		return password.contentEquals(inputPasswd);
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if (!matchPassword(oldPassword))
			throw new IllegalArgumentException("illegal password");
		password = newPassword;
		System.out.println("passwd 수정:" + this);
	}
}
