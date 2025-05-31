package in.ashok.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashok.resposeBinding.Product;


@Service
public class ConsumerService {
	
	
	public void getdata() {
		
		String apiUrl="https://api.restful-api.dev/objects";
		
		RestTemplate rt=new RestTemplate();
		
	 ResponseEntity<Product[]>	resEntity=rt.getForEntity(apiUrl,Product[].class);
	 
	 int status=resEntity.getStatusCode().value();
	
	 if(status==200) {
		 Product[] body=resEntity.getBody();
		 for(Product p:body) {
		 System.out.println(p);
		 }
	 }
	 
	}
	
	public  Product getProdct(String id) {
		
String apiUrl="https://api.restful-api.dev/objects/"+id;
		
		RestTemplate rt=new RestTemplate();
		
	 ResponseEntity<Product>	resEntity=rt.getForEntity(apiUrl,Product.class);
	 
	 int status=resEntity.getStatusCode().value();
		
	 if(status==200) {
		 Product body=resEntity.getBody();
		 
		 System.out.println(body);
		 return body;
	 }
	 else {
		 return null;
	 }
		
	 
	}

}
