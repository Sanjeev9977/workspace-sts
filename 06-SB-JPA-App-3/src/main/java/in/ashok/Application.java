package in.ashok;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashok.service.EmpService;
import in.ashok.service.PersonService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context= SpringApplication.run(Application.class, args);
		
	EmpService es=	context.getBean(EmpService.class);
	
	//es.getAllEmps();
	//es.getAllEmpsPagination();
	//es.getAllEmpsWithFilter();
	
	PersonService ps= context.getBean(PersonService.class);
	ps.savePerson();
	
	}

}
