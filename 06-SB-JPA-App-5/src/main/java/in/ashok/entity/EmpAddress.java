 package in.ashok.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emp_Address1")
public class EmpAddress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;
    private String city;
    private String state;
    private String country;
    private String type;
    
    // Change @ManyToAny to @ManyToOne
    @ManyToOne
    @JoinColumn(name = "eid") // Foreign key to the Employee table
    private Employee emp_var;

    // Getters and setters
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getEmp_var() {
        return emp_var;
    }

    public void setEmp_var(Employee emp_var) {
        this.emp_var = emp_var;
    }
}
