package in.ashok.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Person1 {
	private String name;
	private  String Email;
	private  String gender;
	@EmbeddedId
	private  PersonPK pk;
	public PersonPK getPk() {
		return pk;
	}
	public void setPk(PersonPK pk) {
		this.pk = pk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", Email=" + Email + ", gender=" + gender + "]";
	}

}
