package in.ashok.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ashok.entity.Employee;
import in.ashok.repo.EmpRepository;

@Service
public class EmpService {
	
	private EmpRepository empRepo;

	
	
	public EmpService(EmpRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	public void  callCustomQueries() {
		//List<Employee> e1=empRepo.getAllEmpHQL();
		//e1.forEach(e -> System.out.println(e));
		
//		Employee e1=empRepo.getEmpByid(1);
//		
//		System.out.println(e1);
		
		List<Employee> e1=empRepo.getEmpsSQL();
		e1.forEach(e -> System.out.println(e));
		
	}
	
	public void callCustomQEmpsal() {
	    // If the query returns Object[], since the query only selects ename and salary
	    List<Object[]> e1 = empRepo.getEmpsalSQL();
	    e1.forEach(e -> System.out.println("Name: " + e[0] + ", Salary: " + e[1]));
	}

	
	public void saveEmployeeAll() {
		
		System.out.println(empRepo.getClass().getName());
		
		Employee e=new Employee(8,"nagu",20000);
		Employee e1=new Employee(9,"shivu",40000);
		Employee e2=new Employee(10,"siddu",80000);
		
		List<Employee> li= Arrays.asList(e1,e2,e);
		
		empRepo.saveAll(li);
		
		System.out.println("saved all records..........");
 
		 
		 
	}
	
	public void callfindbyname() {
	List<Employee>	li=empRepo.findByEname("shivu");
	System.out.println("-------callbyfind anme----------");
		li.forEach(e -> System.out.println(e));
		
	}
	public void callfindbysalary() {
	List<Employee>	li=empRepo.findBySalary(20000);
	System.out.println("----------salary-------");
		li.forEach(e -> System.out.println(e));
		
	}	public void callfindbysalarygeterthen() {
	List<Employee>	li=empRepo.findBySalaryGreaterThanEqual(40000);
	  System.out.println("-------------greatthen salary----------");
		li.forEach(e -> System.out.println(e));
		
	}
	
	public void getAllEmps() {
		
		
	Iterable<Employee>	emps= empRepo.findAll();
	
	  
	//emps.forEach(e -> System.out.println(e));
	 
	emps.forEach(System.out::println); //method refrance
		  
	}
	
	public void getEmps(List <Integer> eids) {
	Iterable<Employee>	emps= empRepo.findAllById(eids);
	  
	emps.forEach(e -> System.out.println(e));
	 
	//emps.forEach(System.out::println); //method refrance
		  
	}
	
	public void getEmp() {
		   Optional<Employee>   finduseid =empRepo.findById(10);
		   if(finduseid.isPresent()) {
			   System.out.println(finduseid.get());
		   }
		   else {
			   System.out.println("Record is not found");
		   }
	}
	public void saveEmployee() {
		
		System.out.println(empRepo.getClass().getName());
		
		Employee e=new Employee();
		 e.setEid(1);
		 e.setEname("nagu");
		 e.setSalary(1000000);
		 empRepo.save(e);
		 
		 System.out.println("Record saved.......");
	}
	

}
