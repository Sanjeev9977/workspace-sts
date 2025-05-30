 package in.ashok.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "register") // Optional: Specify table name if different from class name
public class Register {
    
    private String name;

    @Id
    private String email; // Primary Key
    
    private String password; // Changed to String for storing hashed passwords
    
    private Long phoneNo; // Renamed to follow naming conventions

    private String resetToken;
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Long getphoneNo() {
        return phoneNo;
    }
    
    public void setphoneNo(Long phNo) {
        this.phoneNo = phNo;
    }
    public String getResetToken() {
        return resetToken;
    }
    
    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }
    
}
