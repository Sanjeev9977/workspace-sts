package in.ashok.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashok.Entity.Customer;

@RestController
public class DemoRestController {

	@GetMapping("/greet")
	public String getGeetmsg() {
		String msg= "Good Morining";
		return msg;
	}
	
	
	@GetMapping("/welcome")
	public String getWelcomMsg() {
		
		String msg="Welcome To Rest API";
		return msg;
	}
	
	@GetMapping("/greet1/{name}")
	public String getGeetmsg1(@PathVariable("name") String name) {
		String msg=name+" Good Morining";
		return msg;
	}
	
	
	@GetMapping("/welcome1")
	public String getWelcomMsg1(@RequestParam("name")  String name) {
		
		String msg="Welcome To Rest API " +name;
		return msg;
	}
	
	
	@PostMapping("date")
	public String getpost() {
		
		LocalDate ld=LocalDate.now();
		
		
		return String.valueOf(ld); 
	}
	@GetMapping(value = "/welcome2", produces = "text/plain")
	public ResponseEntity<String> getMsg(){
		String msg="Welcome to Ashok IT";
	 return new  ResponseEntity <>(msg,HttpStatus.OK);
	}
	
	@GetMapping(value = "/Customer")
	public ResponseEntity<Customer> getMsg1(){
		Customer c=new Customer("sanjeev","sshishunal@mail.com","9591303974");
	 return new  ResponseEntity <>(c,HttpStatus.OK);
	}
	
	@PostMapping(value = "/Customer2", produces="text/plain", consumes="application/json" )
	public ResponseEntity<String> getMsg3(@RequestBody Customer c){
		 System.out.println(c);
	 return new  ResponseEntity <>("Saved Data",HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/Customer1")
	public ResponseEntity<List<Customer>> getMsg2(){
		Customer c=new Customer("sanjeev","sshishunal@mail.com","9591303974");
		Customer c1=new Customer("ravi","sravi@mail.com","9591303975");
		Customer c2=new Customer("ragu","sragu@mail.com","9591303978");
		List<Customer> list=Arrays.asList(c,c1,c2);
	 return new  ResponseEntity <>(list,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/Customer3/{id}")
	public ResponseEntity<String > deleetCustom(@PathVariable("id")  Integer id){
		
		return new ResponseEntity<>("Customer Delete",HttpStatus.OK);
	}
	
	@PutMapping(value="/Customer4")
	public ResponseEntity<String > updateCustom(@RequestBody Customer c){
		
		return new ResponseEntity<>("Customer Updated",HttpStatus.OK);
	
	}
}
