package in.ashok;

import java.nio.file.Path;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashok.service.EmpService;
import in.ashok.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(Application.class, args);
		
	EmpService es=	context.getBean(EmpService.class);

	//es.saveEmployee();
	//es.saveEmployeeAll();
	//es.getEmp();
	//es.getEmps(Arrays.asList(1,2,3));
	//es.getAllEmps();
	/*
	 * es.callfindbyname(); es.callfindbysalary(); es.callfindbysalarygeterthen();
	 */
	//es.callCustomQueries();	
	
	ProductService ps=context.getBean(ProductService.class);
	//ps.save();
	 ps.getProductSpec("P", 100000.0,20000.0);
	//es.callCustomQEmpsal();
		
			
		
		
		 
	}

}
