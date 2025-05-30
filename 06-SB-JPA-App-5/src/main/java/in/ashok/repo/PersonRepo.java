package in.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.Person;

public interface PersonRepo extends JpaRepository<Person,String> {

}
