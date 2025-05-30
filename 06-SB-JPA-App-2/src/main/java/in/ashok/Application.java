package in.ashok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashok.service.EmpService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext context=	SpringApplication.run(Application.class, args);
	 
	 //UserInterface us= context.getBean(UserInterface.class);
	 //
	 //us.saveUserData();
	 EmpService  e=context.getBean(EmpService.class);
	 e.saveEmp();
	 
	}

}
