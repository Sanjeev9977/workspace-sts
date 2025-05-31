package in.ashok.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.ashok.Repo.RegisterRepo;
import in.ashok.Repo.RegisterServiceRepo;
import in.ashok.entity.Register;


@Service
public class RegisterService implements RegisterServiceRepo {
	
	@Autowired
	private RegisterRepo registerRepo;
	
	


	@Override
	public boolean savedata( Register register) {
		// TODO Auto-generated method stub
		register.setResetToken(null);
		registerRepo.save(register);
		
		
		return true;
	}
	
	

	@Override
	public boolean login(Register register) {
		// TODO Auto-generated method stub
		String email=register.getEmail();
		String password=register.getPassword();
		Register existingRegister = registerRepo.findByEmail(email);
	    if (existingRegister != null) {
	        // Compare the hashed password in the database with the raw password entered
	        return   password.equals(existingRegister.getPassword());
	    }
	    return false;
	}
	
   
	public Register email(Register register) {
		String email=register.getEmail();
		Register existingRegister = registerRepo.findByEmail(email);
		if (existingRegister != null) {
	        // Compare the hashed password in the database with the raw password entered
	        return existingRegister;
	    }
		
		
		return null;
	}

	 
	
	public boolean changepassword( String name,String newPassword) {
		
	    Register user = registerRepo.findByname(name);
	    if (user == null) {
	    	return false;
	    }
		user.setPassword(newPassword);
		registerRepo.save(user);
		return true;
	}

	@Override
	public String getUsernameByEmail(String email) {
		// TODO Auto-generated method stub
		 Register r=  registerRepo.findByEmail(email);
		
		return r.getName();
	}



	@Override
	public boolean findemail(String email) {
		// TODO Auto-generated method stub
	Register	register2=registerRepo.findByEmail(email);

    if (register2 == null) {
    	return false;
    }
	return true;
	}
	
}
