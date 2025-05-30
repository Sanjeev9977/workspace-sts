package in.ashok.entity;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Person {
	
	@Id
	private Integer id;
	private String name;
	private String gender;
	private Date  dateOfBirth;
    @Lob
    private byte[] photo;
    @Lob
    private byte[] resume;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date date) {
		this.dateOfBirth = date;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", date=" + dateOfBirth + ", photo="
				+ Arrays.toString(photo) + ", resume=" + Arrays.toString(resume) + "]";
	}

}
