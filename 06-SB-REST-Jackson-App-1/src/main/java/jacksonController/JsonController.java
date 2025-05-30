package jacksonController;

import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashok.entity.User;

public class JsonController {
	
	
	
	private final ObjectMapper objectMapper;
	
	public JsonController(ObjectMapper objectMapper) {
		this.objectMapper=objectMapper;
	}
	
	@GetMapping("/tojson")
	public String toJson() throws JsonProcessingException {
		
		User user=new User("John Doe", 30, "john@example.com");
		objectMapper.writeValueAsString(user);	
		return null;
		
	}

}
