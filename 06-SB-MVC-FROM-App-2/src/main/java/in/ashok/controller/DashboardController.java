package in.ashok.controller;

import java.util.UUID;

import javax.imageio.spi.RegisterableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashok.Repo.RegisterRepo;
import in.ashok.Repo.RegisterServiceRepo;
import in.ashok.Service.EmailService;
import in.ashok.entity.PasswordReset;
import in.ashok.entity.Product;
import in.ashok.entity.Register;
import in.ashok.exception.UserNotFoundEx;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class DashboardController {
	
	@Autowired
	private RegisterServiceRepo repo;
	
    @Autowired
    private EmailService emailService;
	
    @Autowired
    private RegisterRepo registerRepo;
	  
    @GetMapping("/register")
    public ModelAndView load() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("registerObj", new Register());
        mv.setViewName("register");
        return mv;
    }
	
	@PostMapping("/register")
	public String registersave(Register register,Model model){
		if (register.getName() == null || register.getName().trim().isEmpty()) {
		    register.setName(null);
		}
		boolean emailfind=repo.findemail(register.getEmail());
        if(! emailfind) {
		boolean saved=repo.savedata(register);
		System.out.println(register.getName());
		if(saved) {
		model.addAttribute("msg1","Registed successfully");
        String to = register.getEmail(); // Assuming Register has an email field.
        String subject = "Account Created -SSS";
        String body = "Dear " + register.getName() + ",\n\nThank you for registering with us.\n\nBest Regards,\nYour Team";
        emailService.sendSimpleEmail(to, subject, body);
        model.addAttribute("registerObj", new Register());
		}else {
			model.addAttribute("msg1","Not Registed successfully");	
		model.addAttribute("registerObj", new Register());
		}
		
        }else {
        	model.addAttribute("msg1","This Email Aleardy have Account");	
    		model.addAttribute("registerObj", new Register());	
        }
        return "register";
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("loginObj",new Register());
		 
		mv.setViewName("login");
		return mv;
	}
	
	@PostMapping("/login")
	public String logincheck(Register register, Model model,HttpSession session) throws Exception {
	    boolean login = repo.login(register);  // Call your login logic
	    
	    if (login) {
	    	String username = repo.getUsernameByEmail(register.getEmail());
	    	System.out.println(username != null);
	        if (username != null) {
	            System.out.println("Login successful for user: " + username);
	            session.setAttribute("username", username); // Save username in session
	            model.addAttribute("user", username); // Pass username to the model
	            return "dashboard"; // Redirect to dashboard
	        } else {
	        	throw new UserNotFoundEx("User Not Found");	
	        } 
	        
	    } else {
			
			  // If login fails, show an error message and return to the login form
			  model.addAttribute("msg", "Invalid username or password!");
			  model.addAttribute("loginObj", new Register()); // Clear the form
			  System.out.println("login fails"); 
			  return "login";
			   // Make sure you have a login view
	    	
	    }
 
	}
	
	@GetMapping("/password")
	public ModelAndView passwordload() {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("passwordObj",new Register());
		
		mv.setViewName("password");
		return mv;
	}
	
	@PostMapping("/password")
	public String forgetpassword(Register register,Model model) throws MessagingException {
		
		Register existingRegister=repo.email(register);
		if (existingRegister != null) {
	        // Compare the hashed password in the database with the raw password entered
			String token = UUID.randomUUID().toString();
			
	        existingRegister.setResetToken(token);
	        registerRepo.save(existingRegister);
	        String resetLink = "http://localhost:8080/PasswordReset?token=" + token;
        String to = existingRegister.getEmail(); 
        
        String subject = existingRegister.getName()+", we've made it easy to get back on SSS";
        String htmlBody = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<style>"
                + ".button {"
                + "    display: inline-block;"
                + "    padding: 10px 20px;"
                + "    font-size: 16px;"
                + "    color: #ffffff;"
                + "    text-decoration: none;"
                + "    border-radius: 5px;"
                + "    margin: 10px 0;"
                + "}"
                + ".login-button { background-color: #4CAF50; }"
                + ".reset-button { background-color: #f44336; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<p>Hi <strong>" + existingRegister.getName() + "</strong>,</p>"
                + "<p>Sorry to hear you're having trouble logging into SSS. "
                + "We received a message that you forgot your password. "
                + "If this was you, you can get right back into your account or reset your password now.</p>"
                + "<p><a href='http://localhost:8080/login' class='button login-button'>Log in as " + existingRegister.getName() + "</a></p>"
                + "<p><a href='" + resetLink + "' class='button reset-button'>Reset your password</a></p>"
                + "<p>If you didn’t make this request, please ignore this email.</p>"
                + "<p>Best regards,</p>"
                + "<p>The SSS Team</p>"
                + "</body>"
                + "</html>";

        emailService.sendForgetPasswordEmail(to, subject, htmlBody); 
        model.addAttribute("msg", "We sent an email to "+to+" with a link to get back into your account.");
		model.addAttribute("passwordObj", new Register());
		return "password";
		}
		else {
			model.addAttribute("msg", register.getEmail()+" email id not register...");
			model.addAttribute("passwordObj", new Register());
			return "password";	
			
		}
		
		
	}
	
	@GetMapping("/PasswordReset")
	public String passwordresetload(@RequestParam("token") String token,Model model) {
		
		
 
		
		Register user = registerRepo.findByResetToken(token);
	    if (user != null) {
	        // Token is valid
	    	model.addAttribute("passwordresetObj",new PasswordReset());
	    	 return "passwordreset"; // Show reset password form
	    } else {
	        // Invalid or expired token
	        model.addAttribute("error", "Invalid or expired token.");
	        return "error";
	         
	    }
		 
		
	}
    
	
	@PostMapping("/PasswordReset")
	public String chnagepassword( PasswordReset passwordReset,Model model) {
		
	    
   
		
		if(! passwordReset.getNewPassword().equals(passwordReset.getConformPassword())) {
			
			model.addAttribute("passwordresetObj",new PasswordReset());
			  model.addAttribute("error", "New Password and Confirm Password do not match.");
		        return "passwordreset";
			 
		}
		Register oldpasswordexits=registerRepo.findByPassword(passwordReset.getOldPassword());
		if(oldpasswordexits !=null) {
	     boolean    chenged=repo.changepassword(oldpasswordexits.getName(),passwordReset.getNewPassword());
	     if(chenged) {
	    	 model.addAttribute("passwordresetObj",new PasswordReset());
			  model.addAttribute("success", "succefully Password Changed");
		     return "passwordreset";
	     }
	     else {
	    	 model.addAttribute("passwordresetObj",new PasswordReset());
			  model.addAttribute("error", "error ocurr password changeing time");
		     return "passwordreset";
	     }
			
			
		}
		else {
			model.addAttribute("passwordresetObj",new PasswordReset());
			  model.addAttribute("error", "Old password is incorrect");
		        return "passwordreset";
		}
		
		 
				
				
				
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("username"); // Get username from session
	    session.invalidate(); // Invalidate the session
	    model.addAttribute("user", username); // Pass username for logout message
	     
	    return "logout"; // Redirect to logout page
	}
	
	
	@GetMapping("/dashboard")
	public String showDashboard(HttpSession session, Model model) {
	    // Check if the user is logged in by verifying the session attribute
	    String username = (String) session.getAttribute("username");
	    if (username == null) {
	        // If no username in session, redirect to login page
	        return "redirect:/login";
	    }

	    // If logged in, pass username to the model and show the dashboard
	    model.addAttribute("user", username);
	    return "dashboard";
	}


}
