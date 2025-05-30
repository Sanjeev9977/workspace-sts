package in.ashokit.bean;

import java.lang.reflect.Field;

public class Test {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
    Class<?> clz=Class.forName("in.ashokit.bean.Uesr");
    Object obj=clz.newInstance();
    
    Field ageField=clz.getDeclaredField("age");
     
     ageField.setAccessible(true);
     ageField.set(obj,100);
     
     Uesr u=(Uesr)obj;
     int age=u.getAge();
     System.out.println(age);
    
    
	}

}
