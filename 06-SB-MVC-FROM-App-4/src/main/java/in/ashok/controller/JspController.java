package in.ashok.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JspController {
	
	@Value("${msgTxt}")
	private String msg;
	
	
	@GetMapping("/")
	public String loadjsp(Model model) {
		model.addAttribute("msg","WelCome  Boss");
		return "index";
	}
	
	@GetMapping("/hi")
	@ResponseBody
	public String load() {
		
		
		return msg;
	}

}
