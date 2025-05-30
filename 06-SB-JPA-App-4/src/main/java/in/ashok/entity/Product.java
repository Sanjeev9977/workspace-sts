package in.ashok.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String pid;
	private String  pname;
	private Double  price;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDate CreateDate;
	
	@Column(insertable = false)
	@UpdateTimestamp
	private  LocalDate  UpdateDate;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDate getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(LocalDate createDate) {
		CreateDate = createDate;
	}
	public LocalDate getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		UpdateDate = updateDate;
	}
	@Override
	public String toString() {
		return "ProductService [pid=" + pid + ", pname=" + pname + ", price=" + price + ", CreateDate=" + CreateDate
				+ ", UpdateDate=" + UpdateDate + "]";
	}

}
