package in.ashok.binding;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
	
	
	 @JsonProperty("id")
	private String id;
	 @JsonProperty("price") 
	private Double price;
	 @JsonProperty("email")
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", price=" + price + ", email=" + email + "]";
	}
	

}
