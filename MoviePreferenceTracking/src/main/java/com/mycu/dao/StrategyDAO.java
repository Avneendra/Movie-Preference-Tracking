package com.mycu.dao;

import java.util.ArrayList;

import com.mycu.model.SuperMovie;

public interface StrategyDAO 
{
	public ArrayList<SuperMovie> fetchMovies(long uID);
	public void addMovie(SuperMovie movie);
	public void removeMovie(SuperMovie movie);
}
