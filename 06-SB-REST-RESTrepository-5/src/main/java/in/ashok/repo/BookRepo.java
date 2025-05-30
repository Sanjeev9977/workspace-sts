package in.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import in.ashok.Entity.Books;


@RepositoryRestResource(path = "books")
public interface BookRepo  extends   JpaRepository<Books,Integer> {

}
