package in.ashok.entity.db2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_x")
public class Book {
	
	@Id
	private Integer id;
	
	private  String  name;
	
	

	public Book() {
		 
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name) {
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
		return "Book [id=" + id + ", name=" + name + "]";
	}
	
	

}
