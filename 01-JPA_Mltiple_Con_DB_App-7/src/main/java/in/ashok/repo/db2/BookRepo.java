package in.ashok.repo.db2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashok.entity.db2.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
