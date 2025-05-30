package in.ashok.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegisterValidation {

    private Integer id;

    @NotEmpty(message = "Name is required!")
    @Size(min = 6, max = 20, message = "Name must be between 6 and 20 characters.")
    private String name;

    @NotEmpty(message = "Email is required!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotEmpty(message = "Password is required!")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;

    // Getters and Setters
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

    // Constructors
    public RegisterValidation() {
    }

    public RegisterValidation(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // toString
    @Override
    public String toString() {
        return "RegisterValidation [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }
}
