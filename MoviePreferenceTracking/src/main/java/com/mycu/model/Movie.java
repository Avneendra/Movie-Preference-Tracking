package com.mycu.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MovieName")
public class Movie 
{
	@Id 
	private long   mID;
	
	public String movieTitle;
	
	public long getmID() 
	{
		return mID;
	}
	public void setmID(long mID)
	{
		this.mID = mID;
	}
	public String getMovieTitle() 
	{
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) 
	{
		this.movieTitle = movieTitle;
	}
	public Movie(int mID, String movieTitle) 
	{
		super();
		this.mID = mID;
		this.movieTitle = movieTitle;
	}
	public Movie()
	{
		
	}
	
	
}
