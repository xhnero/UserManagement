package com.user.dto;

import java.util.Date;

public class UserDto {
	 private Integer id;
	    private String name;
	    private String email;
	    private String password;
	    private Date dob;

	    public UserDto() {
	    }

	    public UserDto(Integer id, String name, String email, String password, Date dob) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.password = password;
	        this.dob = dob;
	    }

	    public Integer getId() {
	        return id;

	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public void setDob(Date dob) {
	        this.dob = dob;
	    }

	    public String getName() {
	        return name;

	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public Date getDob() {
	        return dob;
	    }
}
