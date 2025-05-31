package in.ashok.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashok.bilderclass.Passenger;
import in.ashok.bilderclass.Ticket;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class TicketService {

 

  

    public Mono<Ticket> getTicket(Passenger p) {
        System.out.println("🔵 Sending request to /ticket with Passenger: " + p);
        WebClient webClient=WebClient.create();
        
        
        return webClient.post()
            .uri("/ticket")
            .body(BodyInserters.fromValue(p))
            .retrieve()           
            .bodyToMono(Ticket.class);
             
    }


}




	
 
	
	


