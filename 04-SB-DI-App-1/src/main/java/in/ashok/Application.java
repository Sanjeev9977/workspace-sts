package in.ashok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		Robot r = context.getBean(Robot.class);
		r.workdo();
		System.out.println(r.hashCode());
		
		  Robot r1= context.getBean(Robot.class); System.out.println(r1.hashCode());
		 

	}

}
