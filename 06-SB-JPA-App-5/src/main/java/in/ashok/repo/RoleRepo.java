package in.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.Role;

public interface RoleRepo extends JpaRepository<Role,Integer> {

}
