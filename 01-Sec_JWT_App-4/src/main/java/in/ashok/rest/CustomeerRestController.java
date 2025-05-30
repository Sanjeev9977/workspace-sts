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
import in.ashok.service.JWTService;

@RestController
public class CustomeerRestController {
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authManager;
	
	
	@PostMapping("api/register")
	public ResponseEntity<String>  registrationCustomer(@RequestBody Customer c){
		
		String encodePwd=passwordEncoder.encode(c.getPwd());
		c.setPwd(encodePwd);
		repo.save(c);
		return new ResponseEntity<String> ("User Registed", HttpStatus.CREATED);
	}
	
	
	@PostMapping("api/login")
	public  ResponseEntity<String > login(@RequestBody Customer c){
		
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(c.getUname(), c.getPwd());
		try {
			Authentication authenticate=authManager.authenticate(token);
			if(authenticate.isAuthenticated()) {
				String jwtToken=jwtService.generateToken(c.getUname());
				return new ResponseEntity<String>(jwtToken,HttpStatus.OK);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return  new ResponseEntity<String>("Invalid Credentials",HttpStatus.UNAUTHORIZED);
		
		
	}
	

	
	

}
