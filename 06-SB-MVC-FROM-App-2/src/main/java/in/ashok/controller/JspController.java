package in.ashok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JspController {
	
	
	@GetMapping("/jsp")
	public String loadjsp(Model model) {
		model.addAttribute("msg","Welcome Boss");
		return "ind";
		
	}

}
