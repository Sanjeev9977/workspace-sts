package jacksonController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	@GetMapping("/welcome")
	public String getWelcomMsg() {
		
		String msg="Welcome To Rest API";
		return msg;
	}

}
