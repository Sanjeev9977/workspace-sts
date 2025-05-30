 package in.ashok.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "Employee1")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;
    private String name;
    private Double sal;
    
    // One employee can have multiple addresses
    @OneToMany(mappedBy = "emp_var", cascade = CascadeType.ALL)
    private List<EmpAddress> address;

    // Getters and setters
    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public List<EmpAddress> getAddress() {
        return address;
    }

    public void setAddress(List<EmpAddress> address) {
        this.address = address;
    }
}
