package in.ashok.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import in.ashok.service.MsgService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MsgRestContoller {
	
	@Autowired
	private MsgService msgService;
	
	
	 
	@GetMapping("/welcome")
	public String getwelcome() {
	
		String w=msgService.welcom();
	    w=w.toUpperCase();
	    return w;
	}
	
	@GetMapping("/greet")
	public String getGreet() {
	
		String w=msgService.greet();
	    w=w.toLowerCase();
	    return w;
	}

}
