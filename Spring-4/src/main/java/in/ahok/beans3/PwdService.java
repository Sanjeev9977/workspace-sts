package in.ahok.beans3;

import java.util.Base64.Encoder;
import java.util.Base64;

public class PwdService {

	public PwdService() {
		System.out.println(" par pws Constructor");
	}
	
	public String encodePwd(String pwd) {
		Encoder encoder=Base64.getEncoder();
		byte[] encodedPwd=encoder.encode(pwd.getBytes());
		
		
		return new String (encodedPwd);
	}
	

}
