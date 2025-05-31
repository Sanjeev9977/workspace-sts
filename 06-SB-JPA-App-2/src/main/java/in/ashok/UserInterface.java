package in.ashok;

import org.springframework.stereotype.Component;

import in.ashok.Repo.RepositroyInterface;
import in.ashok.entitys.User;

@Component
public class UserInterface {
	
  private	RepositroyInterface Repo;
  
  public UserInterface(RepositroyInterface repo) {
	 
	this.Repo = repo;
}






public void saveUserData() {
	
	User u=new User();
	
	u.setUsername("basavarj");
	u.setEmail("sshishunal@gmail.com");
	u.setPassword("sanjeev@123");
	u.setUserid(1);
	u.setPhoneNo(9591303974L);
	
	Repo.save(u);
	
	System.out.println("Record saved....");
	  
  }
	

}
