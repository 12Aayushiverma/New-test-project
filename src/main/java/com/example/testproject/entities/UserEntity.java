package com.example.testproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userDtls")
public class UserEntity  {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(nullable  = false)
    private String firstName;

    @Column(nullable  = false)
    private String lastName;

    @Column(unique = true)
    private String mobileNumber;

    @Column(unique = true)
    private String email;

    private String about;


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

	public UserEntity(Integer id, String firstName, String lastName, String mobileNumber, String email, String about) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.about = about;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", about=" + about + "]";
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

 
    
}
