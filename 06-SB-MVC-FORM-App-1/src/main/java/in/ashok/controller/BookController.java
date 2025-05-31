package in.ashok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ashok.baindingdata.Book;
 
@Controller
public class BookController {
	
	@GetMapping("/book")
	public ModelAndView loaddata() {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("BookObj",new Book());
		mv.setViewName("Bookview");
		
		return mv;
	}
	
	@PostMapping("/book")
	public ModelAndView getdata( Book book) {
		
		System.out.println(book);
		
		ModelAndView mv =new ModelAndView();
		mv.addObject("msg","form data saved successfully");
		mv.setViewName("success");
		
		return mv;
		
	}

}
