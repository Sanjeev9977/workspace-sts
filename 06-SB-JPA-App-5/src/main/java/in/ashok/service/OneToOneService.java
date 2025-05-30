package in.ashok.service;

import java.time.LocalDate;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.entity.Passport;
import in.ashok.entity.Person;
import in.ashok.repo.PassportRepo;
import in.ashok.repo.PersonRepo;

@Service
public class OneToOneService {
	
	@Autowired
	private PassportRepo passportRepo;
	
	@Autowired
	private PersonRepo personRepo;
	
	public void save() {
		
		Person p=new Person();
		p.setPname("sanjeev");
		p.setPgender("male");
		LocalDate bdate=LocalDate.of(2000, 3,17);
		
		p.setPdateOfBirth(Date.valueOf(bdate));
		
		Passport ps=new Passport();
		ps.setPassport_num("PS123");
		LocalDate idate=LocalDate.of(2026,1,8);
		
		ps.setIssu_date(Date.valueOf(idate));
		LocalDate edate=LocalDate.of(2027, 8, 15);
		
		ps.setExpiration_date(Date.valueOf(edate));
		
		p.setPassport(ps);
		ps.setPerson(p);
		
		personRepo.save(p);
		
		System.out.println("Record saved....");
		
	}
	

}
