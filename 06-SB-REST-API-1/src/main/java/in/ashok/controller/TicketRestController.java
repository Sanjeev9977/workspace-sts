package in.ashok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashok.Entity.Passenger;
import in.ashok.Entity.Ticket;
import in.ashok.service.TicketService;

@RestController
public class TicketRestController {
	
	@Autowired
	private TicketService service;
	
	@PostMapping(value = "/ticket", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger p) {
		
	    System.out.println("Received Passenger: " + p);  // Debugging - Check received data

	    Ticket ticket = service.bookTicket(p);

	    System.out.println("Generated Ticket: " + ticket);  // Debugging - Check created ticket

	    return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	}

	
	
	@GetMapping(value = "ticket/{tid}" ,produces = "application/json")
	public ResponseEntity<Ticket> getTicket(@PathVariable("tid") Integer tid){
		
		
		Ticket t=service.getTicket(tid);
		return new ResponseEntity<Ticket> (t,HttpStatus.OK);
	}
	
	@GetMapping(value = "/tickets",produces ="application/json")
	public ResponseEntity<List<Ticket>> getTickets(){
		
		List<Ticket> tickets=service.getTickets();
		
		return new ResponseEntity<List<Ticket>>(tickets,HttpStatus.OK);
		
	}
	
	
}
