package in.ashok.entity.db3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	private Integer id;
	
	private  String name;
	
	

	public Product() {
		 
		// TODO Auto-generated constructor stub
	}



	public Product(Integer id, String name) {
		 
		this.id = id;
		this.name = name;
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
		return "Product [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	

}
