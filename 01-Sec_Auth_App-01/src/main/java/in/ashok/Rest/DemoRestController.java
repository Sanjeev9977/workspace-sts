package in.ashok.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	
	
	@GetMapping("/login")
	public String login() {
		
		return "Good morning ";
	}
	
	@GetMapping("/deposit")
	public String deposit() {
		
		return "Good morning ";
	}
	
	@GetMapping("/withdraw")
	public String withdraw() {
		
		return "Good morning ";
	}
	
	
	@GetMapping("/contant")
	public String transection() {
		
		return "Good morning ";
	}
	
	@GetMapping("/about")
	public String admin1() {
		
		return "Good morning ";
	}

}
