package in.ashok.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rid;
	private String  rname;
	
	@ManyToMany(mappedBy ="roles")
	private List<User> uid;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public List<User> getUid() {
		return uid;
	}

	public void setUid(List<User> uid) {
		this.uid = uid;
	}
	
	
	
	

}
