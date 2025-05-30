package in.ashok.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashok.enity.Customer;
import in.ashok.repo.CustomerRepo;
import in.ashok.security.AppSecurityConfig;

@RestController
public class CustomeerRestController {
	
	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authManager;
	
	
	@PostMapping("/login")
	public  ResponseEntity<String > loginCheck(@RequestBody Customer c){
		
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(c.getEmail(), c.getPwd());
		try {
			Authentication authenticate=authManager.authenticate(token);
			if(authenticate.isAuthenticated()) {
				return new ResponseEntity<String>("Welcom to Ashok IT",HttpStatus.OK);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return  new ResponseEntity<String>("Invalid Credentials",HttpStatus.UNAUTHORIZED);
		
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody Customer c){
		
		String encodePwd=passwordEncoder.encode(c.getPwd());
		c.setPwd(encodePwd);
		repo.save(c);
		return new ResponseEntity<String> ("User Registed", HttpStatus.CREATED);
	}
	
	

}
