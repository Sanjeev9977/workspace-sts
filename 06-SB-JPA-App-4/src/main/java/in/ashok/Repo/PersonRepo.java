package in.ashok.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.Person1;
import in.ashok.entity.PersonPK;

public interface PersonRepo extends JpaRepository<Person1, PersonPK> {

}
