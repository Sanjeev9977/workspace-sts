package in.ashok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ashok.baindingdata.User;

@Controller
public class FormController {
	
	@GetMapping("/load")
	public ModelAndView loaddata() {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("users",new User());
		mv.setViewName("index");
		
		return mv;
	}
	
	@PostMapping("/getdata")
	public ModelAndView getdata() {
		
		ModelAndView mv =new ModelAndView();
		mv.addObject("msg1","form data saved successfully");
		mv.setViewName("success");
		
		return mv;
		
	}
	
	

}
