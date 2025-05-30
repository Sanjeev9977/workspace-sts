package in.ashok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.dao.UserDao;

@Service
public class UserService {
	
	private UserDao userDao;
	
	

	  
 
/*    @Autowired
	public void setUserDao(UserDao userDao) {
		System.out.println("UserService :setter");
		this.userDao = userDao;
	}*/


	public UserService() {
		System.out.println("UserService :Constractor");
	}
    //if u have only one parameter constractor than u no need to write @Autowired
	@Autowired
    public UserService(UserDao userDao) {
		System.out.println("UserService :Parameter Constractor");
    	this.userDao=userDao;
    }
	
	
	public void getName(int id) {
		System.out.println(userDao.findName(id));
		
	}
	
	
	

}
