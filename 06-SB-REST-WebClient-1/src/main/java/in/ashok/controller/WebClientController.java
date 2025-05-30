package in.ashok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashok.bilderclass.Product;
import in.ashok.service.ProductNotFound;
import in.ashok.service.WebClientService;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {
	
	@Autowired
	private  WebClientService service;
	
	@GetMapping("/product")
	public ResponseEntity<Mono<String>> getProduct(){
		int a=1/0;
		Mono<String>  response=service.getProduct();		
		return new ResponseEntity<Mono<String>>(response,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/product1/{id}")
	public ResponseEntity<Mono<Product>> getProductNew(@PathVariable("id") Integer id)  throws Exception{
		if(id<=5) {
		Mono<Product> product=service.getProductNew(id);
		return new ResponseEntity<Mono<Product>>(product,HttpStatus.OK);
		}else {
			throw new ProductNotFound("Invalid id");
		}
			
		
	}
	

}
