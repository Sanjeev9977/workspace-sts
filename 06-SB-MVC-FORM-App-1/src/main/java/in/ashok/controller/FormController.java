package in.ashok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ashok.baindingdata.User;

@Controller
public class FormController {
	
	@GetMapping("/user")
	public ModelAndView loaddata() {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("userObj",new User());
		mv.setViewName("index");
		
		return mv;
	}
	
	@PostMapping("/user")
	public ModelAndView getdata( User user) {
		
		System.out.println(user);
		
		ModelAndView mv =new ModelAndView();
		mv.addObject("msg","form data saved successfully");
		mv.setViewName("success");
		
		return mv;
		
	}
	
	

}
