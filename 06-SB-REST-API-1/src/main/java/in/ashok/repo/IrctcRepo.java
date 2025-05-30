package in.ashok.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.Entity.TicketBookers;

public interface IrctcRepo extends JpaRepository<TicketBookers,String>{
	
	
	Optional<TicketBookers >  findByTicketId(String ticketId);

}
