package in.ashok.entitys;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	
	private String username;
	@Id
	private Integer userid;
	private String password;
	private String Email;
	private long  phoneNo;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long  getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", userid=" + userid + ", password=" + password + ", Email=" + Email
				+ ", phoneNo=" + phoneNo + "]";
	}
	
	
	

}
