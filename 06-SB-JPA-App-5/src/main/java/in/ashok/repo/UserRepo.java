package in.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
