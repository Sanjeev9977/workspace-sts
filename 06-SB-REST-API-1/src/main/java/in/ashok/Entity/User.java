package in.ashok.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    
    @Id
	private Long id;
	private String name;
	private  String email;
	private  String pNumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getpNumber() {
		return pNumber;
	}
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	
	public User() {
		 
	}
	
	public User(Long id, String name, String email, String pNumber) {
	 
		this.id = id;
		this.name = name;
		this.email = email;
		this.pNumber = pNumber;
	}
	 
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", pNumber=" + pNumber + "]";
	}
	
	
	
}
