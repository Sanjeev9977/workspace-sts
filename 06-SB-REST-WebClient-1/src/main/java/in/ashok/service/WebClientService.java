package in.ashok.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashok.bilderclass.Product;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {
	
	
	
	public Mono<String> getProduct(){
		
		String apiUrl="https://api.restful-api.dev/objects/1";
		
		WebClient webclient=WebClient.create();
		
		                Mono<String> responcebody=webclient.get()
	                                              .uri(apiUrl)
		                                           .retrieve()
                                                   .bodyToMono(String.class);	
		                
		            System.out.println(responcebody);    
		return responcebody;
		
		
	}
	
	public Mono<Product> getProductNew(Integer id){
		
		String apiUrl="https://api.restful-api.dev/objects/"+id;
		
		WebClient webClient=WebClient.create();
		                     
		Mono<Product> p=webClient.get()
        	            .uri(apiUrl)
        	            .retrieve()
                        .bodyToMono(Product.class);
		
		
		System.out.println(p.toString());
		
        	            return p;
		
	}
	
	
}
