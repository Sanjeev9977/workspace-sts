package in.ashok.bean2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ApplicationContext con=new ClassPathXmlApplicationContext("bean.xml");
		
		UserService	obj=con.getBean(UserService.class);
		 System.out.println(obj.getName(200));
		
		

	}

}
