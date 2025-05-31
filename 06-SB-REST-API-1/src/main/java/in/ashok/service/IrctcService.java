package in.ashok.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.Entity.TicketBookers;
import in.ashok.Entity.TicketBookers.TicketStatus;
import in.ashok.repo.IrctcRepo;

@Service
public class IrctcService {
	
	private static final Logger logger = LoggerFactory.getLogger(IrctcService.class);
	 @Autowired
     private	IrctcRepo irctcRepo; 
	
    public TicketBookers save(TicketBookers bookers) {
		
		try {
			boolean ticketAvalible=true;
			if(ticketAvalible)
				bookers.setTicketStatus(TicketStatus.BOOKED);
			else
				bookers.setTicketStatus(TicketStatus.WAITLISTED);
			
			TicketBookers bookers2=	irctcRepo.save(bookers);
		  return bookers2;
		}
		catch(Exception e){
			logger.error("Error saving bookers: {}", e.getMessage(), e);
			return null;
		}		
	}
    
    public TicketBookers getTicket(String id) {
        try {
            TicketBookers ticket = irctcRepo.findByTicketId(id).orElse(null);
            
            if (ticket == null) {
                logger.warn("No ticket found for ID: {}", id);
                return null; // Or an appropriate default value
            }

            return ticket;
        } catch (Exception e) {
            logger.error("Error retrieving ticket for ID {}: {}", id, e.getMessage(), e);
            return null; // Or handle error appropriately
        }
    }
    
    
    public List<TicketBookers> getAllTicket(){
    	try {
		  List<TicketBookers> AllTicket=irctcRepo.findAll();
		  return AllTicket;
		}
		catch(Exception e){
			logger.error("Error saving bookers: {}", e.getMessage(), e);
			return null;
		}		
    	
    }


}
