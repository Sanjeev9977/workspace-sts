package in.ashok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.Entity.User;
import in.ashok.repo.UserRepo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepo userRepo;
	
	public boolean save(User user) {
		
		try {
		userRepo.save(user);
		  return true;
		}
		catch(Exception e){
			logger.error("Error saving user: {}", e.getMessage(), e);
			return false;
		}		
	}
	
	public List<User> getall(){
		
		try {
		List<User> s=userRepo.findAll();
		
		return s;
		}catch(Exception e){
			logger.error("Error saving user: {}", e.getMessage(), e);
			 return Collections.emptyList();
		}
		
	}
	
	public boolean deleteuser(String  name ) {
    try {		
	Optional<User> u=	userRepo.findByName(name);
	if(u.isPresent()) {
		userRepo.delete(u.get());
		return true;
	}else {
		logger.warn("User with name '{}' not found", name);
        return false; // User not found
	}
	
    }catch(Exception e){
    	logger.error("Error saving user: {}", e.getMessage(), e);
    	return false;
    }
		
		
	}
	
	public boolean update(User u) {
	
	try {	
	Optional<User> user=	userRepo.findById(u.getId());
	
	if(user.isPresent()) {
		
		userRepo.save(u);
		return true;
	}else {
		logger.warn("User with id '{}' not found", u.getId());
        return false; // User not found
	}
		
	}catch(Exception e) {
		logger.error("Error saving user: {}", e.getMessage(), e);
		
		return false;
	}
	
	}
	
	public boolean saved(List<User> users) {
		
		try {
			userRepo.saveAll(users);
			
			return true;
		}catch(Exception e){
			logger.error("Error saving user: {}", e.getMessage(), e);
			return false;
		}
	}
	

}
