package in.ashok.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entitys.EmpAddress;

public interface EmpAddRepo extends JpaRepository<EmpAddress,Integer> {

}
