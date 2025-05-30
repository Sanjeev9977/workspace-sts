package in.ashok.rest;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	
	private HashOperations<String,Object,Object> operations;
	
	public DemoRestController(RedisTemplate<String,String> rt) {
		
		this.operations=rt.opsForHash();
	}

	
	@PostMapping("/user")
	public String saveData() {
		operations.put("USERS", 102,"Basu");
		
		return "Data Saved";
		
	}
	
	@GetMapping("/user")
	public String getUserName() {
		
	return (String)	operations.get("USERS", 101);
	}
	
	@GetMapping("/users")
	public Map<Object,Object> getAllUser(){
		
		return operations.entries("USERS");
	}
	
}
