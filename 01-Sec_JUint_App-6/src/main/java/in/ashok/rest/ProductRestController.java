package in.ashok.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashok.beans.Product;

@RestController
public class ProductRestController {
	
	@PostMapping("product")
	public ResponseEntity<String> getProduct(@RequestBody Product product){
		
		System.out.println(product);

		return new ResponseEntity<String>("Product Saved",HttpStatus.CREATED);
	}

}
