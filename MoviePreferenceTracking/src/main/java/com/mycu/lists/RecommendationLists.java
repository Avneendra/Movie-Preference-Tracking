package com.mycu.lists;

import java.util.ArrayList;



import com.mycu.dao.ContextDAO;
import com.mycu.dao.MovieDAO;

import com.mycu.dao.RecommendationDAO;

import com.mycu.model.Moviedisplayformat;
import com.mycu.model.SuperMovie;

public class RecommendationLists implements StrategyLists
{
	public long mID,uID;
	public String movieTitle;
	public boolean wish,ignore;
	public int ratings;
	
	
	MovieDAO moviedao= new MovieDAO();
	ContextDAO context = new ContextDAO(new RecommendationDAO());
	
	
	public RecommendationLists() 
	{
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Moviedisplayformat> fetchMovies(long uID)
	{
		ArrayList<SuperMovie> movies= new ArrayList<SuperMovie>();
		ArrayList<Moviedisplayformat> formatmovies= new ArrayList<Moviedisplayformat>();	
		
		movies=context.executeFetchMovieStrategy(uID);
		
		for(SuperMovie mov: movies)
		{
			mID=mov.getmID();;
			movieTitle=moviedao.getMovie(mID);
			ratings=0;
			wish= false;
			ignore=true;
			
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


