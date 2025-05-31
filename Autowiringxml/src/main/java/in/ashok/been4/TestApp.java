package in.ashok.been4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ApplicationContext con=new ClassPathXmlApplicationContext("bean.xml");
		Callprinter son=con.getBean(Callprinter.class);
		  son.printer();

	}

}
