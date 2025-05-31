package in.ashok.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import in.ashok.dao.UserDao;
import in.ashok.service.UserService;

@SpringBootTest
@ExtendWith(value = {MockitoExtension.class})
public class UserServiceTest {
	
	@MockBean
	private UserDao dao;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	public void testGetUsername() {
		when(dao.findName(101)).thenReturn("Basavaraj");
		String userName=userService.getUserName(101);
		assertEquals("Basavaraj", userName);
	}

}
