package in.ashok.Entity;

public class Customer {
	
	
	private String name;
	
	private String email;
	
	private String phoneNo;
	
	public Customer() {
		
	}

	public Customer(String name, String email, String phoneNo) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + "]";
	}
	
	
	

}
