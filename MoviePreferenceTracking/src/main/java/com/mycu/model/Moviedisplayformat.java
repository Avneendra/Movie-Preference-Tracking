package com.mycu.model;

public class Moviedisplayformat 
{
	public String movieTitle;
	public boolean wish;
	public boolean ignore;
	public int ratings;
	
	public Moviedisplayformat()
	{
		// TODO Auto-generated constructor stub
	}

	public String getMovieTitle() 
	{
		return movieTitle;
	}

	public Moviedisplayformat(String movieTitle, boolean wish, boolean ignore, int ratings) 
	{
		super();
		this.movieTitle = movieTitle;
		this.wish = wish;
		this.ignore = ignore;
		this.ratings = ratings;
	}

	public void setMovieTitle(String movieTitle) 
	{
		this.movieTitle = movieTitle;
	}

	public boolean isWish() 
	{
		return wish;
	}

	public void setWish(boolean wish) 
	{
		this.wish = wish;
	}

	public boolean isIgnore() 
	{
		return ignore;
	}

	public void setIgnore(boolean ignore) 
	{
		this.ignore = ignore;
	}

	public int getRatings() 
	{
		return ratings;
	}

	public void setRatings(int ratings) 
	{
		this.ratings = ratings;
	}
	
	

}
