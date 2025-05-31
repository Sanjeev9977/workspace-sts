package in.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.Entity.Ticket;

public interface TicketRepository  extends JpaRepository<Ticket,Integer> {

}
