package in.ashok.baindingdata;

public class User {
	
	
   private	String name;
   private  String email;
   private  Long PhoneNo;
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
public Long getPhoneNo() {
	return PhoneNo;
}
public void setPhoneNo(Long phoneNo) {
	PhoneNo = phoneNo;
}
@Override
public String toString() {
	return "User [name=" + name + ", email=" + email + ", PhoneNo=" + PhoneNo + "]";
}
   
   
}
