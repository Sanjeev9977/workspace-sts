package in.ashok.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	

	public UserDao() {
		System.out.println("User : Constructor");
	}

	public String findName(int id) {
	   if(id==100) {
		return "sanjeev";
	  }
	   else {
		return "shishunal";
	  }
	}
	
}
