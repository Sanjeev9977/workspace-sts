package in.ashok.service;

import org.springframework.stereotype.Service;

@Service
public class MsgService {
	
	public String welcom() {
		return "Welcome Ashok IT";
		
	}

	
	public String greet() {
		return "Good Morning";
	}
}
