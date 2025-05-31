package in.ashok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.Repo.EmpAddRepo;
import in.ashok.Repo.EmpRepo;
import in.ashok.entitys.EmpAddress;
import in.ashok.entitys.Employee;
import jakarta.transaction.Transactional;

@Service

public class EmpService {

	@Autowired
	private EmpRepo empRepo;
	
	@Autowired
	private EmpAddRepo empAddRepo;
	
	@Transactional(rollbackOn =Exception.class)
	public void saveEmp() {
		
		Employee e=new Employee();
		e.setName("sanju");
		e.setSalary(62000.0);
		Employee emp=empRepo.save(e);
		
		//int a=10/0;
		
		EmpAddress ed=new EmpAddress();
		ed.setCity("Haveri");
		ed.setState("Karnataka");
		ed.setCountry("India");
		ed.setEid(emp.getEid());
		
		empAddRepo.save(ed);
		
		System.out.println("Record saved.....");
		
	}
	
}
