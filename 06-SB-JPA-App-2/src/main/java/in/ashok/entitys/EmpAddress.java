package in.ashok.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emp_Address")
public class EmpAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aid;
	private String city;
	private String state;
	private String country;
	private String eid;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String string) {
		this.eid = string;
	}
	@Override
	public String toString() {
		return "EmpAddress [aid=" + aid + ", city=" + city + ", state=" + state + ", country=" + country + ", eid="
				+ eid + "]";
	}
	
	
	
	

}
