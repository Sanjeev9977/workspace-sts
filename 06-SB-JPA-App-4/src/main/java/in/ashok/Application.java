package in.ashok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashok.Service.PersonService;
import in.ashok.Service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext context=	SpringApplication.run(Application.class, args);
	
	
	// ProductService pr= context.getBean(ProductService.class);
	  // pr.saveProduct();
	   
	 //  pr.callProductSp(10,2024);
	PersonService ps=context.getBean(PersonService.class);
	//ps.savePerson();
	ps.getPerson();
	}

}
