package in.ashok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao UserDao;
	
	public String getUserName(Integer uid) {
		String findName=UserDao.findName(uid);
		System.out.println("Name : "+ findName);
		return findName;
	}
	
	

}
