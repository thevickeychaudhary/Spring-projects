package com.liaa.dto;


public class UserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String contactId;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public UserRequestDto(String firstName, String lastName, String email, String password, String contactId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contactId = contactId;
	}
	public UserRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserRequestDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", contactId=" + contactId + "]";
	}
    
}
