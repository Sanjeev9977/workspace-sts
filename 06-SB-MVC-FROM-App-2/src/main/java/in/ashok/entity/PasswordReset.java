package in.ashok.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PasswordReset {
	
    @NotBlank(message = "Old password cannot be blank")
    @Size(min = 4, max = 4,message = "Old password must be exactly 4 digits")
	private String oldPassword;
	
    
    @NotBlank(message = "New password cannot be blank")
    @Size(min=4,max=4,message = "New password must be exactly 4 digits")
	private String newPassword;
	
    @NotBlank(message = "Confirm password cannot be blank")
    @Size(min=4,max=4, message = "Confirm password must be exactly 4 digits")
	private String conformPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConformPassword() {
		return conformPassword;
	}

	public void setConformPassword(String conformPassword) {
		this.conformPassword = conformPassword;
	}
    
    
	
	

}
