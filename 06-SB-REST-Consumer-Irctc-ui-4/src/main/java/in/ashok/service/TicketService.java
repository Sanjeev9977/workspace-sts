package in.ashok.service;

 
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
 

import in.ashok.BilderClass.Passenger;
import in.ashok.BilderClass.Ticket;
import reactor.core.publisher.Mono;

 

@Service
public class TicketService {

 

  

    public Mono<Ticket> getTicket(Passenger p) {
        System.out.println("🔵 Sending request to /ticket with Passenger: " + p);
        
        
        String apiUrl="http://localhost:8081/tick'=et";
        WebClient webClient=WebClient.create();
        
        
        return webClient.post()
            .uri(apiUrl)
            .header("Content-Type", "application/json")
            .body(BodyInserters.fromValue(p))
            .retrieve()           
            .bodyToMono(Ticket.class);
             
    }
    
public Mono<Ticket> getTicketinfo(Integer id){
		
		String apiUrl="http://localhost:8081/ticket/"+id;
		
		WebClient webClient=WebClient.create();
		                     
		Mono<Ticket> p=webClient.get()
        	            .uri(apiUrl)
        	            .retrieve()
                        .bodyToMono(Ticket.class);
		
		
		 
		
        	            return p;
		
	}


public Mono<List<Ticket>>  getTickets(){
	String apiUrl="http://localhost:8081/tickets";
	WebClient client=WebClient.create();
	
	return client.get()
			.uri(apiUrl)
			.retrieve()
			.bodyToMono(new ParameterizedTypeReference<List<Ticket>>() {});
	
}


}




	
 
	
	


