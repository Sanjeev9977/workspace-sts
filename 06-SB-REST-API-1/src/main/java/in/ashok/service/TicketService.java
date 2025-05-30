package in.ashok.service;

import java.util.List;

import in.ashok.Entity.Passenger;
import in.ashok.Entity.Ticket;

public interface TicketService {
	
	
	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketId);
	
	public List<Ticket> getTickets();

}
