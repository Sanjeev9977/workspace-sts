package in.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee,Integer> {

}
