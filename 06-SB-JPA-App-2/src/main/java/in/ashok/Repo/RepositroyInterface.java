package in.ashok.Repo;

import org.springframework.data.repository.CrudRepository;

import in.ashok.entitys.User;

public interface RepositroyInterface extends CrudRepository<User,Integer> {

}
