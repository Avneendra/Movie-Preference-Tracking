package com.mycu.controller;


import org.springframework.beans.factory.annotation.Autowired;



import com.mycu.dao.MovieDAO;


public class MovieController 
{
	public  long mID;
	public String movieTitle;
	
	@Autowired
	MovieDAO moviedao= new MovieDAO();

	public String getMovie(long mID)
	{
		movieTitle=moviedao.getMovie(mID);
		
		return movieTitle;
	}
	
	public long getMID(String movieTitle)
	{
		mID= moviedao.getMID(movieTitle);
		return mID;
	}
	
}
