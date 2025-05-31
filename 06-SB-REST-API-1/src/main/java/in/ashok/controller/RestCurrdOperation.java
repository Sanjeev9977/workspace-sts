package in.ashok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashok.Entity.Customer;
import in.ashok.Entity.User;
import in.ashok.service.UserService;

@RestController
public class RestCurrdOperation {
	
	@Autowired
	private   UserService service;
	
	@GetMapping(value="/getUser" ,produces ="application/json")
	public ResponseEntity<User> getUser(){
		User u=new User((long) 1,"sanjeev","sanjeev@gmail.com","9591303974");
		return new ResponseEntity<User> (u ,HttpStatus.OK); 
	}
	
	
	
	
	@PostMapping(value ="/save",produces ="text/plain",consumes ="application/json")
	public ResponseEntity<String>  saveUser(@RequestBody User u) {
		
		boolean save=service.save(u);
		if(save)
		     return new ResponseEntity<>("Saved",HttpStatus.CREATED);
		else
			return new ResponseEntity<>("INTERNAL_SERVER_ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/users" ,produces ="application/json")
	public ResponseEntity<List<User>> getall(){
		List<User> users=service.getall();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@DeleteMapping(value ="/delete/{name}")
	public ResponseEntity<String>  deleteUser(@PathVariable("name") String name){
		
		 boolean delete= service.deleteuser(name);
		 if(delete) 
			 return new ResponseEntity<String> ("User Deleted",HttpStatus.OK);
		 else
		   return new ResponseEntity<String> ("INTERNAL_SERVER_ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value="/UserUpdate")
	public ResponseEntity<String > updateCustom(@RequestBody User c){
		
		boolean update=service.update(c);
		
		if(update)
		return new ResponseEntity<>("User Updated",HttpStatus.OK);
		else
		return new ResponseEntity<String> ("INTERNAL_SERVER_ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	@PostMapping(value ="/usersall" ,produces ="text/plain" ,consumes ="application/json")
	public ResponseEntity<String> Users(@RequestBody  List<User> u){
		
		boolean saved=service.saved(u);
		
		if(saved) 
		return new ResponseEntity<>("saved all Users",HttpStatus.OK);
		else
		return	new ResponseEntity<String> ("INTERNAL_SERVER_ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
		
			
	}
	

}
