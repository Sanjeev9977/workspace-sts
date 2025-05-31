package in.ashok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashok.service.ManyToManyService;
import in.ashok.service.OneToManyService;
import in.ashok.service.OneToOneService;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext context=	SpringApplication.run(Application.class, args);
	//OneToOneService one=context.getBean(OneToOneService.class);
	
	//one.save();
	
	//OneToManyService om=context.getBean(OneToManyService.class);
	
	//om.save();
	//om.getdata();
	//om.empDelete();
	//om.getAdress();
	
	ManyToManyService mm=context.getBean(ManyToManyService.class);
	mm.save();
	}

}
 