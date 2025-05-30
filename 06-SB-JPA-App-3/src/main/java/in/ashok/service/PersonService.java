package in.ashok.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Service;


import in.ashok.entity.Person;
import in.ashok.repo.PersonRepo;

@Service
public class PersonService {
	
	private PersonRepo prRepo;

	public PersonService(PersonRepo prRepo) {
		 
		this.prRepo = prRepo;
	}
	
	public void savePerson() throws IOException {
		
		System.out.println(prRepo.getClass().getName());
		
		 Person p=new Person();
		 p.setId(1);
		 p.setName("sanjeev");
		 p.setGender("Male");
		 LocalDate birthdate = LocalDate.of(2000, 3,17);
		 p.setDateOfBirth(Date.valueOf(birthdate));
		 String photoPath = "‪E:\\Downloads\\1731084542472.jpg";
	     photoPath = sanitizeFilePath(photoPath);
		 File photoFile = new File(photoPath);
		 if (!photoFile.exists()) {
		     System.out.println("Photo file does not exist at the specified path.");
		 } else {
		     byte[] photo = Files.readAllBytes(photoFile.toPath());
		     // Process the photo...
		 }
		 String ResumePath = "C:/Users/Admin/Downloads/Resume_Sanjeev shishunal new.pdf";
		 ResumePath = sanitizeFilePath(ResumePath);
		 File ResumeFile = new File(ResumePath);
		 byte[] photo = Files.readAllBytes(photoFile.toPath());
		 byte[] Resume = Files.readAllBytes(ResumeFile.toPath());
		 p.setPhoto(photo);
		 p.setResume(Resume);
		 prRepo.save(p);
		 
		 System.out.println("Record saved.......");
	}
	
	 // Helper method to sanitize the file path
    private String sanitizeFilePath(String filePath) {
        // Remove non-ASCII characters (including invisible characters like LRM)
        return filePath.replaceAll("[^\\x00-\\x7F]", "");
    }
}
