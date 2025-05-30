package in.ashok.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.ModuleLayer.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashok.beans.Product;

@WebMvcTest(controllers=ProductRestController.class)
public class ProductRestControllerTest {
	
	@Autowired
	private  MockMvc mockMvc; 
	
	
	@Test
	public void testSaveProduct() throws Exception {
		Product product=new Product();
		product.setPid(101);
		product.setPname("Iphone");
		
		ObjectMapper mapper=new ObjectMapper();
		String productJson=mapper.writeValueAsString(product);
		
		MockHttpServletRequestBuilder reqBuild=MockMvcRequestBuilders.post("/product")
		                                       .contentType("application/json")
		                                       .content(productJson);
		
		MvcResult result=mockMvc.perform(reqBuild).andReturn();
		MockHttpServletResponse response=result.getResponse();
		int status=response.getStatus();
		assertEquals(201, status);
		
		
		
	}

}
