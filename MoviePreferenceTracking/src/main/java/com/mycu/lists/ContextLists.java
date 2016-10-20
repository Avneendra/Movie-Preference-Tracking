package com.mycu.lists;

import java.util.ArrayList;

import com.mycu.model.SuperMovie;
import com.mycu.model.Moviedisplayformat;

public class ContextLists 
{

	private StrategyLists strategy;
	
	public ContextLists(StrategyLists strategy) 
	{
		this.strategy=strategy;
	}
	
	public ArrayList<Moviedisplayformat> executeFetchMovieStrategy(long uID)
	{
	      return strategy.fetchMovies(uID);
	}
	
	public void executeAddMovieStrategy(SuperMovie movie)
	{
		
			strategy.addMovie(movie);
		
	}
	
	public void executeRemoveMovieStrategy(SuperMovie movie)
	{
		
			strategy.removeMovie(movie);
		
	}
}
