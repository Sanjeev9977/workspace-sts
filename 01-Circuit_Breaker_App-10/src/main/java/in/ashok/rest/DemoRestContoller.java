package in.ashok.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DemoRestContoller {
	
	
	@GetMapping("/data")
	@CircuitBreaker(fallbackMethod ="getDataFromDB",name ="ashokit" )
	public String getDataFromRedis() {
		System.out.println("**** redis() - method excuted -----");
		
		int i=10/0;
		return "Data Fached Redis Server";
	}
	
	public String getDataFromDB(Throwable t) {
		System.out.println("***** d() -method excuted ----");
		
		return "Data Fathed From DB Server";
		
	}

}
