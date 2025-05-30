package in.ahok.beans3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	//	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		//PwdService pw1=context.getBean(PwdService.class);
		PwdService pw2=context.getBean(PwdService.class);
		Engine en=context.getBean(Engine.class);
		
		//System.out.println(pw1.hashCode());
		System.out.println(pw2.hashCode());
		System.out.print(en.dowork());
		System.out.println(pw2.encodePwd("sanjeev"));
		
		
		context.close();
		
		
		

	}

}
