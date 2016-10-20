package com.mycu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Userprofile")
public class User 
{
	@Id 
	@GeneratedValue
	private long    uId;
	public String fName,lName, userName;
	private String email,password;
	
	public long getuId() 
	{
		return uId;
	}
	public void setuId(long uId) 
	{
		this.uId = uId;
	}
	public String getfName() 
	{
		return fName;
	}
	public void setfName(String fName) 
	{
		this.fName = fName;
	}
	public String getlName()
	{
		return lName;
	}
	public void setlName(String lName) 
	{
		this.lName = lName;
	}
	public String getuserName() 
	{
		return userName;
	}
	public void setuserName(String userName) 
	{
		this.userName = userName;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getpassword() 
	{
		return password;
	}
	public void setpassword(String password)
	{
		this.password = password;
	}
	public User(String fName, String lName, String userName, String email, String password) 
	{
		super();
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	public User() 
	{
		super();
	}
	
	

}