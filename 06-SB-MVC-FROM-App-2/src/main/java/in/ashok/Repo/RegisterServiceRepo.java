package in.ashok.Repo;

import in.ashok.entity.Register;

public interface RegisterServiceRepo  {
	
	public boolean savedata( Register register);
	
	public boolean login( Register register);
	
	public Register  email(Register register);
	
    public boolean changepassword(String username,String newpassword);	 
    
    public String getUsernameByEmail(String email);
	
    public boolean  findemail(String email); 

}
