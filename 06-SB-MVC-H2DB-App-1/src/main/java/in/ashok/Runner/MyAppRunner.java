package in.ashok.Runner;

 

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashok.Repo.ContactRepo;
import in.ashok.entity.Contact;
@Component 
public class MyAppRunner implements ApplicationRunner {
 @Autowired
 private	ContactRepo contactRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		Contact c=new Contact();
		c.setName("sanjeev");
		c.setPhno(9591303);
		
		Contact c1=new Contact();
		c1.setName("sanjeev");
		c1.setPhno(9591303);
		
		contactRepo.saveAll(Arrays.asList(c,c1));
		
		
	}

}
