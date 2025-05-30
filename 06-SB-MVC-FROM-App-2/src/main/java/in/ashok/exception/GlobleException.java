package in.ashok.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleException  {
	@ExceptionHandler(value=UserNotFoundEx.class)
	public String UserHandle(UserNotFoundEx user,Model model) {
		model.addAttribute("error",user.getMessage());
		return "error";
	}
	

	@ExceptionHandler(value=Exception.class)
	public String hendle(Exception e,Model model) {
		model.addAttribute("error", e.getMessage());
		return "error";
		
	}
}
