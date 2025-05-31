package in.ashok.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Random;
import java.util.UUID;

public class TessApp {
	
	public static String generateRandomName() {
		 String[] names = {"Alice", "Bob", "Charlie", "David", "Eva"};
		 Random rand = new Random();
	        return names[rand.nextInt(names.length)];  // Shorten the UUID for brevity
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ApplicationContext con =new ClassPathXmlApplicationContext("bean.xml");
      BookServiceImpl bs=con.getBean(BookServiceImpl.class);
      Random rand = new Random();
      int id = rand.nextInt(100);
      int max=100,min=50;
      int price =rand.nextInt(max - min + 1) + min;
      String Name=generateRandomName();
      
      bs.saveBook(id,Name,price);
      bs.getName(id);
      bs.fachall();
      bs.update_data(id,id+max);
      bs.delet(74);
     
	}

}
