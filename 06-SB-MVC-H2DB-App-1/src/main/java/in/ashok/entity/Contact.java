package in.ashok.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue
	private Integer cid;
	private String  name;
	private Integer   phno;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhno() {
		return phno;
	}
	public void setPhno(int i) {
		this.phno = i;
	}
	@Override
	public String toString() {
		return "Contact [cid=" + cid + ", name=" + name + ", phno=" + phno + "]";
	}
	

}
