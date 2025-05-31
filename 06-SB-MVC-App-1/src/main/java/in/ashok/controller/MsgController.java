package in.ashok.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ashok.entity.Product;

import java.util.List;

import  org.springframework.stereotype.Controller;

@Controller
public class MsgController {
	
	@GetMapping("/greet")
	public ModelAndView getMsg1(Product Products) {
		
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg1",Products.getPname());
		mv.setViewName("index");
		
		return mv;
		
	}
	@GetMapping("/wish")
	public ModelAndView getMsg2() {
		
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg2","Hello Boss Good Morning");
		mv.addObject("msg1","Hi Hello Friends...");
		mv.setViewName("index");
		
		return mv;
		
	}

}
