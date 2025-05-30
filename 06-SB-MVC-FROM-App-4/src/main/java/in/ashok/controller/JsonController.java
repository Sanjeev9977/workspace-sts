package in.ashok.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import in.ashok.entity.User;


@RestController
@RequestMapping("/api/json")
public class JsonController {
	
	
	
	private final ObjectMapper objectMapper;
	
	public JsonController(ObjectMapper objectMapper) {
		this.objectMapper=objectMapper;
	}
	
	@GetMapping("/tojson")
	public String toJson() throws JsonProcessingException {
		
		User user=new User("John Doe", 30, "john@example.com");
		 	
		return objectMapper.writeValueAsString(user);
		
	}
	
	
	
	  @GetMapping("/toobject") public User convertToObject(@RequestParam String
	  json) throws JsonProcessingException { return objectMapper.readValue(json,
	  User.class); }
	 
	
	 



	

}
