package in.ashok.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entitys.Employee;

public interface EmpRepo extends JpaRepository<Employee,String> {

}
