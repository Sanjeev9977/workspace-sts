package in.ashok.entity;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "person_passport_tbl1")
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer passport_id;
	private String passport_num;
	private Date issu_date;
	private Date expiration_date;
	
	@OneToOne
	@JoinColumn(name = "pid")
	private Person person_m_var;

	public Integer getPassport_id() {
		return passport_id;
	}

	public void setPassport_id(Integer passport_id) {
		this.passport_id = passport_id;
	}

	public String getPassport_num() {
		return passport_num;
	}

	public void setPassport_num(String passport_num) {
		this.passport_num = passport_num;
	}

	public Date getIssu_date() {
		return issu_date;
	}

	public void setIssu_date(Date issu_date) {
		this.issu_date = issu_date;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public Person getPerson() {
		return person_m_var;
	}

	public void setPerson(Person person) {
		this.person_m_var = person;
	}

	@Override
	public String toString() {
		return "Passport [passport_id=" + passport_id + ", passport_num=" + passport_num + ", issu_date=" + issu_date
				+ ", expiration_date=" + expiration_date + ", person=" + person_m_var + "]";
	}
	
	
}
