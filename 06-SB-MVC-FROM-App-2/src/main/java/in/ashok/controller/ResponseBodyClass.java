package in.ashok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ResponseBodyClass {
	
	@GetMapping("/hi")
	public String msg1() {
		 return "Hi Hello";
	}
	
	@GetMapping("/hello")
	public String  msgLoad(Model model) {
		model.addAttribute("msg","Hi Friends");
		return "index";
	}
	

}
