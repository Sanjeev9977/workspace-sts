package in.ashok.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashok.clients.WelcomApiFeignClient;

@RestController
public class GreetRestController {
	
	@Autowired
	private WelcomApiFeignClient client;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/greet")
	public String greet() {
		
		String welcome=client.invokeWelcomeApi();
		
		String port=env.getProperty("server.port");
		  
		String msg="Good Morning ("+port+")  ,";
		return msg+welcome;
	}

}
