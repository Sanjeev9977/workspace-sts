package in.ashok.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.ashok.service.CustomerService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	
	@Autowired
	private CustomerService customerService;
	
	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public  AuthenticationProvider authProvider() {
		DaoAuthenticationProvider  authprovider=new DaoAuthenticationProvider(); //it has to load data from db
		authprovider.setUserDetailsService(customerService);
		authprovider.setPasswordEncoder(pwdEncoder());
		return authprovider;
		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration  config) throws Exception{
		return config.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		return http.csrf()
				   .disable()
				   .authorizeHttpRequests()
				   .requestMatchers("/register","/login")
				   .permitAll()
				   .and()
				   .build();
	}
	

}
