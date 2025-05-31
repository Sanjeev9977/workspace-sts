package in.ashok.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.entity.Role;
import in.ashok.entity.User;
import in.ashok.repo.RoleRepo;
import in.ashok.repo.UserRepo;

@Service
public class ManyToManyService {
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private  RoleRepo roleRepo;
	
	
	public void save() {
		
		Role  r=new Role();
		r.setRname("singer");
		
		Role r1=new Role();
		r1.setRname("former");
		
		
		User u=new User();
		u.setName("basavaraj");
		LocalDate udb=LocalDate.of(2000,3,17);
		u.setUserdb(udb);
		u.setGender("Male");
		
		u.setRoles(Arrays.asList(r,r1));
		
		userRepo.save(u);
		

		
		
	}

}
