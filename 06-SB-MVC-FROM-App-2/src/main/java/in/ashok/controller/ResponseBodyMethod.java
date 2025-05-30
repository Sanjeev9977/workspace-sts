package in.ashok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyMethod {
	
	@GetMapping("/msg")
	public String  msgLoad(Model model) {
		model.addAttribute("msg","Hi Friends");
		return "index";
	}

	
	@GetMapping("/msg2")
	@ResponseBody
	public String  msg2Load() {
		
		return "Hi Friends Hegidira";
	}

}
