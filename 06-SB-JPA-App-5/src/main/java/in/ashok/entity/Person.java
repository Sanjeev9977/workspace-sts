package in.ashok.entity;

 

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "person1_tbl1")
public class Person {
	
	@Id
	@GeneratedValue(generator ="psn_custom_id_generator")
	@GenericGenerator(name = "psn_custom_id_generator",strategy ="in.ashok.generatore.PsnCustomIdGeneratore")
	private String pid;
	private String pname;
	private String pgender;
	private Date pdateOfBirth;
	
	@OneToOne(mappedBy = "person_m_var",cascade = CascadeType.ALL)
    private Passport passport;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPgender() {
		return pgender;
	}

	public void setPgender(String pgender) {
		this.pgender = pgender;
	}

	public Date getPdateOfBirth() {
		return pdateOfBirth;
	}

	public void setPdateOfBirth(Date pdateOfBirth) {
		this.pdateOfBirth = pdateOfBirth;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", pgender=" + pgender + ", pdateOfBirth=" + pdateOfBirth
				+ ", passport=" + passport + "]";
	}
    
    
	 


}
