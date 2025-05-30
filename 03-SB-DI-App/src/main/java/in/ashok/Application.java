package in.ashok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashok.dao.UserDao;
import in.ashok.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext context=	SpringApplication.run(Application.class, args);
	
	UserService us=context.getBean(UserService.class);
	
	us.getName(100);
      
	System.out.println();

	}

}
