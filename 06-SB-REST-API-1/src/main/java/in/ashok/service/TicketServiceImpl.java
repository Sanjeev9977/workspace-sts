package in.ashok.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.Entity.Passenger;
import in.ashok.Entity.Ticket;
import in.ashok.repo.TicketRepository;

@Service
public class TicketServiceImpl implements  TicketService {
	
	@Autowired
	private TicketRepository repo;

	@Override
	public Ticket bookTicket(Passenger passenger) {
		// TODO Auto-generated method stub
		Ticket t=new Ticket();
		
		BeanUtils.copyProperties(passenger, t);
		
		t.setTicketStatus("CONFIRMED");
		
		Ticket savedTicket=repo.save(t);
		
		
		
		return savedTicket;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		// TODO Auto-generated method stub
		return repo.findById(ticketId).orElseThrow();
	}

	@Override
	public List<Ticket> getTickets() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
