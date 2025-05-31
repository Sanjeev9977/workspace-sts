package in.ashok.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class PersonPK {
	
	private Integer id;
	private String  Num;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}
	@Override
	public String toString() {
		return "PersonPK [id=" + id + ", Num=" + Num + "]";
	}
	

}
