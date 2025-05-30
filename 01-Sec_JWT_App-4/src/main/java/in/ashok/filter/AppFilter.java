package in.ashok.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import in.ashok.service.CustomerService;
import in.ashok.service.JWTService;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AppFilter extends OncePerRequestFilter {
	@Autowired
	private JWTService jwtService;
    
	@Autowired
	private CustomerService customerService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		String token=null;
		String username=null;
		
		//check Authorriztion header presence
		String authHeader=request.getHeader("Authorization");
		
		//if header present, retrieve bearer token
		if(authHeader !=null && authHeader.startsWith("Bearer")) {
			token=authHeader.substring(7);
			username=jwtService.extractUsername(token);
		}
		
		//validate token
		// if token is valid, update security context with auth token
		
		if(username !=null && SecurityContextHolder.getContext().getAuthentication() ==null) {
			UserDetails userDetails=customerService.loadUserByUsername(username);
			if(jwtService.validateToken(token, userDetails)) {
				
				UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
