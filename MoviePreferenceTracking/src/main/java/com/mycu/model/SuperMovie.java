package com.mycu.model;


import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class SuperMovie 
{
	@Id
    public long mID;
    public long uID;
    public int rating;
    
   	public int getRating() 
   	{
   		return rating;
   	}

   	public void setRatings(int rating) 
   	{
   		this.rating = rating;
   	}

	public long getmID() 
	{
		return mID;
	}

	public void setmID(long mID) 
	{
		this.mID = mID;
	}

	public long getuID() 
	{
		return uID;
	}

	public void setuID(long uID) 
	{
		this.uID = uID;
	}

}
