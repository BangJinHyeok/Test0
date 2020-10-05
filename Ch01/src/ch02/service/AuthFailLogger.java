package ch02.service;

public class AuthFailLogger {
	
	private int threshold;
	private int failCounts;
	
	public void insertBadPw(String userId, String inputPw) {
		System.out.printf("AuthFail [type=badpw, userid=%s, pw=%s]\n", userId, inputPw);
		failCounts++;
		if (threshold > 0 && failCounts > threshold) {
			notifyTooManyFail();
			failCounts = 0;
		}
	}
	
	private void notifyTooManyFail() {
		System.out.println("너무 많은 로그인 시도 실패");
	}
	
	//setter 방식, xml에서 와이어링을 함
	public void setThreshold(int thresold) {
	      this.threshold = thresold;
	   }

}
