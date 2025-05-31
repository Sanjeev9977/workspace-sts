package in.ashok.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.Register;

public interface RegisterRepo extends JpaRepository<Register,String> {
	
	
	public  Register findByEmail(String email);
	
 
	public  Register  findByPassword(String password);
	
	public Register findByname(String name);
	
	Register findByResetToken(String resetToken);
	
}
