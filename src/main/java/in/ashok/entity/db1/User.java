package in.ashok.entity.db1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_x")  //Hi 
public class User {
	
	@Id
	private Integer id;
	
	private String   name;
	
	

	public User() {
		  
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	

}
