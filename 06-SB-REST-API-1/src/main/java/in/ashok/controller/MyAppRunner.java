package in.ashok.controller;

 

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

 
import in.ashok.Entity.User;
 
import in.ashok.repo.UserRepo;
@Component 
public class MyAppRunner implements ApplicationRunner {
 @Autowired
 private	UserRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		 
		
	}

}
