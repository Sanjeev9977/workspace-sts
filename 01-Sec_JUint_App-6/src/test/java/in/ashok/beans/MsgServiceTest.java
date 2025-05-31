package in.ashok.beans;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MsgServiceTest {
	
	@Autowired
	private  in.ashok.service.MsgService msgService;
	
	@Test
	public void testWelcome() {
		String welcome=msgService.welcom();
		assertNotNull(welcome);
	}
	
	@Test
	public void testgreet() {
		String greet=msgService.greet();
		assertNotNull(greet);
	}
	
	
	

}
