package in.ashok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ExController {
	
	
	@GetMapping("/new")
	public String showMag1(Model mv) {
		 
		
		mv.addAttribute("msg","Hi hello");
		 
		return "index";
		
	}
	
	@GetMapping("/old")
	public ModelAndView showMag() {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("msg","good morning");
		mv.setViewName("index");
		return mv;
		
	}

}
