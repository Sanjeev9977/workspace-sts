package in.ashok.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.entity.EmpAddress;
import in.ashok.entity.Employee;
import in.ashok.repo.EmpAddreRepo;
import in.ashok.repo.EmpRepo;

@Service
public class OneToManyService {
    
    @Autowired
    private EmpRepo empRepo;
    
    @Autowired
    private EmpAddreRepo addreRepo;
    
    public void empDelete() {
    	empRepo.deleteById(1);
    }
    
    public void getEmp() {
    	Optional<Employee> findAll= empRepo.findById(1);
    	if(findAll.isPresent()) {
    		Employee emp=findAll.get();
    		
    	List<EmpAddress> emps=emp.getAddress();
    	
    	
    	}
    }
    public void getAdress() {
    	Optional<EmpAddress> findAll= addreRepo.findById(1);
    	if(findAll.isPresent()) {
    		EmpAddress emp=findAll.get();
    		
    	Employee emps=emp.getEmp_var();
    	
    	
    	}
    }
    
    public void save() {
        // Create a new Employee
        Employee e = new Employee();
        e.setName("sanjeev");
        e.setSal(200000.0);
        
        // Create two EmpAddress objects
        EmpAddress ed1 = new EmpAddress();
        ed1.setCity("Haveri");
        ed1.setState("Karnataka");
        ed1.setCountry("India");
        ed1.setType("Past");
        
        EmpAddress ed2 = new EmpAddress();
        ed2.setCity("Sullurupeta");
        ed2.setState("Andhra Pradesh");
        ed2.setCountry("India");
        ed2.setType("Present");
        
        // Set the Employee to each EmpAddress
        ed1.setEmp_var(e);
        ed2.setEmp_var(e);
        
        // Associate the addresses with the Employee
        e.setAddress(Arrays.asList(ed1, ed2));
        
        // Save the Employee (this will cascade and save EmpAddress as well)
        empRepo.save(e);
    }
}
