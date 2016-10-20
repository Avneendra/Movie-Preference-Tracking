package com.mycu.lists;

import java.util.ArrayList;

import com.mycu.dao.ContextDAO;

import com.mycu.dao.MovieDAO;
import com.mycu.dao.RatingsDAO;

import com.mycu.model.SuperMovie;
import com.mycu.model.Moviedisplayformat;

public class RatingsList implements StrategyLists
{
	public long mID,uID;
	public String movieTitle;
	public boolean wish,ignore;
	public int ratings;

	MovieDAO moviedao= new MovieDAO();
	ContextDAO context = new ContextDAO(new RatingsDAO());
	
	
	public RatingsList() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Moviedisplayformat> fetchMovies(long uID)
	{
		System.out.println("Inside fetchMovies in Ratinsg list");
		ArrayList<SuperMovie> movies= new ArrayList<SuperMovie>();
		ArrayList<Moviedisplayformat> formatmovies= new ArrayList<Moviedisplayformat>();	
		
		movies=context.executeFetchMovieStrategy(uID);
		
		for(SuperMovie mov: movies)
		{
			mID=mov.getmID();
			movieTitle=moviedao.getMovie(mID);
			ratings=mov.getRating();
			wish= false;
			ignore=false;
			
			Moviedisplayformat formatmovie = new Moviedisplayformat(movieTitle,wish,ignore,ratings);
			formatmovies.add(formatmovie);
			
		}
		
		return formatmovies;
	}
	
	
	public void addMovie(SuperMovie movie)
	{
			
		context.executeAddMovieStrategy(movie);
			
	}
	
	public void removeMovie(SuperMovie movie)
	{
		context.executeRemoveMovieStrategy(movie);
				
	}
}
