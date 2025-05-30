package in.ashok.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashok.Entity.Product;

@RestController
public class XmlToObject {
	
	@GetMapping(value ="/getProduct",produces = {"application/json","application/xml"})
	public ResponseEntity<Product> getProduct(){
		
		Product p=new Product("Pen",10,50);
		return new ResponseEntity<Product> (p,HttpStatus.OK);
	}
	
	@PostMapping(value ="putProduct",consumes = {"application/json","application/xml"})
	public ResponseEntity<String> putProduct(@RequestBody Product product){
		
		System.out.println(product);
		
		return new ResponseEntity<String>("Product saved",HttpStatus.CREATED);
	}

}
