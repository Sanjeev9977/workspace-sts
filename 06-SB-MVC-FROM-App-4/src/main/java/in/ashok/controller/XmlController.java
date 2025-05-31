package in.ashok.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import in.ashok.entity.User;

@RestController
@RequestMapping("/api/xml")
public class XmlController {
	
	
	private final XmlMapper xmlMapper;

	public XmlController(XmlMapper xmlMapper) {
	 
		this.xmlMapper = xmlMapper;
	} 
	
	@GetMapping(value = "/toxml", produces = "application/xml")
    public User toxml() {
        return new User("John Doe", 30, "john@example.com");
    }
	
	@PostMapping(value = "/toxmlobj", consumes = "application/xml")
    public User convertToObject(@RequestBody String xml) throws JsonProcessingException {
        return xmlMapper.readValue(xml, User.class);
    }
	
	
	

}
