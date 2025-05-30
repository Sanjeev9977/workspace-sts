package in.ashok.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashok.BilderClass.Passenger;
import in.ashok.BilderClass.Ticket;
import in.ashok.service.TicketService;
import reactor.core.publisher.Mono;

@Controller
public class TicketController {
	  
	@Autowired
	 private TicketService service;
	
	
	@GetMapping("/dashboard")
	public String  dashboard(Model model ) {
	    
 
		return "dashboard";
	}
	
	
	@GetMapping("/bookticket")
	public String  bookTicketpage(Model model ) {
	    
		model.addAttribute("ticketObj",new Passenger() );
		return "bookticket";
	}
	
	@PostMapping("/bookticket")
	public Mono<String> bookTicket(Passenger p, Model model) {
	    System.out.println("🔵 Request received for booking a ticket");
	    
	    // Fetch the ticket using the reactive method
	    return service.getTicket(p)
	        .doOnSuccess(ticket -> {
	            // Do something with the ticket if needed (e.g., adding attributes)
	            model.addAttribute("ticket", ticket);
	        })
	        .thenReturn("ticketinfo"); // This will return a Mono<String> to resolve asynchronously
	}


	@GetMapping("/alltickets")
	public String getAllTickets(Model model) {
	    Mono<List<Ticket>> tickets = service.getTickets();  // Call your service to get tickets
	    model.addAttribute("tickets", tickets);
	    return "tickets";  // Return the name of the Thymeleaf template (alltickets.html)
	}

	@GetMapping("/ticket")
	public String  getTicket(Model model ) {
	    
		model.addAttribute("ticketObj",new Ticket() );
		return "ticket";
	}

	
	@PostMapping("/ticket")
	public String getProductNew(Ticket tid,Model model) {
	    Mono<Ticket> ticket = service.getTicketinfo(tid.getTicketId());
	    model.addAttribute("ticketObj",tid );
	    model.addAttribute("ticket", ticket);
	    return "ticket";
	}


}
