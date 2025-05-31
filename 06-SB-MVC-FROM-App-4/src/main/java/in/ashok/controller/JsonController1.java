package in.ashok.controller;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashok.entity.User;

public class JsonController1 {
	
	
	public static void main (String [] argo) throws Exception{
		
		JsonController1 json=new JsonController1();
		json.convertjavaTojson();
		json.convertjsonTojava();
		
		
	}
	
	public void convertjavaTojson() throws Exception {
		User u=new User("sajeev",24,"sshishunal@gmail.com");
		ObjectMapper mapper=new ObjectMapper();
	     mapper.writeValue(new File("User.json"),u);
		System.out.println("Json created....");	
	}
	
	public void convertjsonTojava() throws Exception {
		ObjectMapper mapper=new ObjectMapper();
		 User u=  mapper.readValue( new File("User.json"),User.class);
		 System.out.println(u);
		
	}

}
