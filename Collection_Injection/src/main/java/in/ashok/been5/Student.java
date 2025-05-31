package in.ashok.been5;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	
	private Integer id;
	private String name;
	private List <String> Cource;
	private Set <String> hobbies;
	private Map <String,String> phone;
	
	public  Student() {
		System.out.println("constructor");
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
	public List<String> getCource() {
		return Cource;
	}
	public void setCource(List<String> cource) {
		Cource = cource;
	}
	public Set<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Map<String, String> getPhone() {
		return phone;
	}
	public void setPhone(Map<String, String> phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Cource=" + Cource + ", hobbies=" + hobbies + ", phone="
				+ phone + "]";
	}
	
	
	

}
