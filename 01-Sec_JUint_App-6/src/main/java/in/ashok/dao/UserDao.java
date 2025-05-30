package in.ashok.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	public String findName (Integer uid) {
		return "Sajeev";
	}

}
