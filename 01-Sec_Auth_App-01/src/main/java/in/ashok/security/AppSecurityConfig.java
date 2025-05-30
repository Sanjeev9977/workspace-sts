package in.ashok.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager inMemUsers() {
		
		UserDetails u1=User.withDefaultPasswordEncoder()
				       .username("sanjeev")
				       .password("sanjeev@123")
				       .roles("User")
				       .build();
		
		UserDetails u2=User.withDefaultPasswordEncoder()
				   .username("basu")
			       .password("basu@123")
			       .roles("Admin")
			       .build();
		
		return new InMemoryUserDetailsManager(u1,u2);
		
		
		
	}
	
	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		http.authorizeHttpRequests((authorize) ->authorize
//				         .requestMatchers("/contant","/about").permitAll()
//		                 .anyRequest()
//		                 .authenticated())
//		                 .formLogin();
//		
//		return http.build();
//	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests(authorize -> authorize
	            .requestMatchers("/contant", "/about").permitAll()
	            .requestMatchers("/deposit").hasRole("User")
	            .requestMatchers("/withdraw").hasRole("Admin")
	            .anyRequest().authenticated()
	    )
	    .formLogin();

	    return http.build();
	}

	
	
	
	
	

}
