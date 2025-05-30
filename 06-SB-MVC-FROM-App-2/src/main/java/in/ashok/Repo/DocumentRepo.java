package in.ashok.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.Document;

public interface DocumentRepo extends JpaRepository<Document,String> {
	
	
	public Optional<Document>  findByFileName(String fileName);

}
