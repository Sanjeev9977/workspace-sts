package in.ashok;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	@GetMapping("/")
	public String welcome() {
		return "Sanjeev Shishunal";
	}

}
