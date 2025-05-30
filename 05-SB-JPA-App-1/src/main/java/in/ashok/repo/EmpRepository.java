package in.ashok.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.ashok.entity.Employee;


public interface EmpRepository extends CrudRepository<Employee, Integer> {
	
	@Query("from Employee")
	public List<Employee> getAllEmpHQL();
	
	@Query("from Employee where eid=:id")
	public Employee getEmpByid(Integer id);
	
	@Query(value="select * from Employee", nativeQuery =true)
	public List<Employee> getEmpsSQL();
	
	//@Query(value="select n.ashok.entity.Employee.Employee(e.ename,e.salary) from Employee e",nativeQuery = true)
	//public List<Employee> getEmpsalSQL();
	
	@Query("select e.ename, e.salary from Employee e")
	public List<Object[]> getEmpsalSQL();

	
	// select * from table where ename="ename";
	public List<Employee> findByEname(String ename);
	
	public List<Employee> findBySalary( Integer salary);
	
	public List<Employee> findBySalaryGreaterThanEqual(Integer salary);
}
