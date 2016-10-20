package com.mycu.dao;

import java.util.ArrayList;

import com.mycu.model.SuperMovie;

public class ContextDAO 
{
	private StrategyDAO strategy;
	
	public ContextDAO(StrategyDAO strategy) 
	{
		this.strategy=strategy;
	}
	
	public ArrayList<SuperMovie> executeFetchMovieStrategy(long uID)
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
