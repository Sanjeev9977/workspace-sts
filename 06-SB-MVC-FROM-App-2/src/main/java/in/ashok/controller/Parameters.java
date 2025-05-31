package in.ashok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.websocket.server.PathParam;

@Controller
public class Parameters {
	
	@GetMapping("/queryParam")
	public String queryParam(@RequestParam("name") String name,Model model ) {
		model.addAttribute("msg",name+" Welcome to To Our Website");
		
		return "parameters";
	}
	
	@GetMapping("/pathParam/{name}")
	public String pathParam(@PathVariable("name") String name,Model model ) {
		model.addAttribute("msg",name+" Welcome to To Our Website");
		
		return "parameters";
	}

}
