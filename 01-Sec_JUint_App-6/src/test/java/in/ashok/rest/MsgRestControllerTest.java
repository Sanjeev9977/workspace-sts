package in.ashok.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.AbstractMockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.ashok.service.MsgService;

@WebMvcTest(controllers = MsgRestContoller.class)
public class MsgRestControllerTest {
	
	@MockBean
	private MsgService msgService;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testWelcome() throws Exception{
		
		//define moke object behaviour
		when(msgService.welcom()).thenReturn("GOOD MORINING...");
		
		//prepare requst
		MockHttpServletRequestBuilder reqbilder=MockMvcRequestBuilders.get("/welcome");
		//send request
		MvcResult mvcResult=mockMvc.perform(reqbilder).andReturn();
		
		//
		MockHttpServletResponse response=mvcResult.getResponse();
		
		String actStatusContent=response.getContentAsString();
		
		
		
		 
		assertEquals("GOOD MORINING...", actStatusContent);
	}
	
	
	
	@Test
	public void testGreet() throws Exception{
		
		//define moke object behaviour
		when(msgService.greet()).thenReturn("Dumm Test");
		
		//prepare requst
		MockHttpServletRequestBuilder reqbilder=MockMvcRequestBuilders.get("/greet");
		//send request
		MvcResult mvcResult=mockMvc.perform(reqbilder).andReturn();
		
		//
		MockHttpServletResponse response=mvcResult.getResponse();
		
		int actStatusCode=response.getStatus();
		
		
		int expectedStatusCode=200;
		assertEquals(expectedStatusCode, actStatusCode);
	}

}
