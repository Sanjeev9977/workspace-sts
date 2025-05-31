package in.ashok.repo.db1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashok.entity.db1.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
	
	

}
