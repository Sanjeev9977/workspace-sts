package in.ashok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.method.support.ModelAndViewContainer;

import in.ashok.bilderclass.Passenger;
import in.ashok.bilderclass.Ticket;
import in.ashok.service.TicketService;
import reactor.core.publisher.Mono;

@Controller
public class TicketController {
	  
	@Autowired
	 private TicketService service;
	
	@GetMapping("/bookticket")
	public String  bookTicketpage(Model model ) {
	    
		model.addAttribute("ticketObj",new Passenger() );
		return "bookticket";
	}
	
	@PostMapping("/bookticket")
	public String  bookTicket (Passenger p,Model model){
		
		model.addAttribute("ticketObj",p );
		Mono<Ticket>  t=service.getTicket(p);
		 System.out.println(t);
		return "bookticket";
		
	}

}
