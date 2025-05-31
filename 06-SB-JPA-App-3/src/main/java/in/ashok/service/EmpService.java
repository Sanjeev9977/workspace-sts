package in.ashok.service;

 
import java.util.List;
 


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;


import in.ashok.entity.Employee;
import in.ashok.repo.EmpRepository;

@Service

public class EmpService {
	
	
	private EmpRepository empRepo;

	
	
	public EmpService(EmpRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	public void getAllEmps() {
	Sort sort=	Sort.by("salary","ename").descending();
	Iterable<Employee>	emps= empRepo.findAll(sort);
	  
	//emps.forEach(e -> System.out.println(e));
	 
	emps.forEach(System.out::println); //method refrance
		  
	}
	
	public void getAllEmpsPagination() {
		/**
		 * Creates a new {@link PageRequest} with sort parameters applied.
		 *
		 * @param pageNumber zero-based page number, must not be negative.
		 * @param pageSize the size of the page to be returned, must be greater than 0.
		 * @param sort must not be {@literal null}, use {@link Sort#unsorted()} instead.
		 * @since 2.0
		 */
	 
		int PageSize=2; //fixd value
		int PageNum=3; // wiil come UI
		
		PageRequest pg=PageRequest.of(PageNum-1, PageSize);
		
		  Page<Employee>  page = empRepo.findAll(pg);  
		  
		  List<Employee>  emps=page.getContent();	
	 
	  
	//emps.forEach(e -> System.out.println(e));
	 
	emps.forEach(System.out::println); //method refrance
		  
	}
	
	public void getAllEmpsWithFilter() {
		
		
	Employee entity=new Employee();
	
	//if emp name come from UI
	entity.setEname("nagu");
	
	// if Salary comes from UI
	entity.setSalary(20000); //=
	
	Example<Employee> ex=Example.of(entity);
	 
	
		
	List<Employee>	emps= empRepo.findAll(ex);
	
	  
	//emps.forEach(e -> System.out.println(e));
	 
	emps.forEach(System.out::println); //method refrance
		  
	}

}
