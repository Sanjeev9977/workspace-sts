package in.ashok.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.Repo.DocumentRepo;
import in.ashok.entity.Document;

@Service
public class DocumentService {
	
	@Autowired
	private DocumentRepo documentRepo;
	
	
	public boolean saveData(Document document) {
		
		documentRepo.save(document);
		
		return true;
		
		
	}
	
	public Optional<Document> file(String name) {
		
		Optional<Document> d=documentRepo.findByFileName(name);
		return d;
		
	}
	

}
