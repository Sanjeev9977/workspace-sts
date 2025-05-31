package in.ashok.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.Repo.PersonRepo;
import in.ashok.entity.Person1;
import in.ashok.entity.PersonPK;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepo repo;
	
	public void getPerson() {
		PersonPK pk=new PersonPK();
		pk.setId(1);
		pk.setNum("AIT123");
		
		Optional<Person1> fid=repo.findById(pk);
		if(fid.isPresent()) {
		   Person1 ps=fid.get();
		   System.out.println(ps);
		}
	}
	
	public void savePerson() {
		PersonPK pk=new PersonPK();
		pk.setId(1);
		pk.setNum("AIT123");
		
		Person1 p=new Person1();
	     p.setName("sanjeev");
	     p.setGender("male");
	     p.setEmail("sshishunal@gmail.com");
	     p.setPk(pk);
	     
	     repo.save(p);
	     
	}
	

}
