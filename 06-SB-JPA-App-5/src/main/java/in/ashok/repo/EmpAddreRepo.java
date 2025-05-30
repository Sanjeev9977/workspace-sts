package in.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.EmpAddress;

public interface EmpAddreRepo extends JpaRepository<EmpAddress,Integer> {

}
