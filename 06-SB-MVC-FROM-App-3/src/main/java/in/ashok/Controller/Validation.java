package in.ashok.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ashok.entity.RegisterValidation;
import jakarta.validation.Valid;

@Controller
public class Validation {
	
	@GetMapping("/register")
	public  ModelAndView loadregister() {
		ModelAndView mv =new ModelAndView();
		
		mv.addObject("user",new RegisterValidation());
		mv.setViewName("register");
		
		return mv;
		
	}
    
	
	@PostMapping("/register")
	public String registerPost(@Valid RegisterValidation registerValidation, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	 List<String> errorMessages = new ArrayList<>();
	         result.getAllErrors().forEach(error -> errorMessages.add(error.getDefaultMessage()));
	         model.addAttribute("user", registerValidation);
	         model.addAttribute("errorMessages", errorMessages);
	        return "register"; // Return the same view
	    }
	    model.addAttribute("user", registerValidation);
	    model.addAttribute("msg", "User data saved successfully!");
	    return "register";
	}




}

