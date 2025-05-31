package in.ashok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ashok.entity.RegisterValidation;
import jakarta.validation.Valid;

@Controller
public class ValidationController {
	
	@GetMapping("/register1")
	public  ModelAndView loadregister() {
		ModelAndView mv =new ModelAndView();
		
		mv.addObject("register1Obj",new RegisterValidation());
		mv.setViewName("register1");
		
		return mv;
		
	}
    
	
	@PostMapping("/register1")
	public String regisertPost(@Valid RegisterValidation rvalidation ,BindingResult result,Model model) {
		
        if(result.hasErrors()) {
        	 model.addAttribute("register1Obj", rvalidation);
			System.out.println(rvalidation);
			return "register1";
			
		}else {
			
			System.out.println(rvalidation);
			 
			return "register1";
		}
		 
		
	}
}
