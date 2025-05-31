package in.ashok.been5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext con=new ClassPathXmlApplicationContext("bean5.xml");
		Student s=con.getBean(Student.class);
		System.out.println(s);

	}

}
