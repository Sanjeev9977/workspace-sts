package in.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.Entity.User;
import java.util.List;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User,Long>   {

	
	
	
	Optional<User> findByName(String name);
}
