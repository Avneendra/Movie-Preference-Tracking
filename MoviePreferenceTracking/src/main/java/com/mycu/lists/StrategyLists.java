package com.mycu.lists;

import java.util.ArrayList;

import com.mycu.model.SuperMovie;
import com.mycu.model.Moviedisplayformat;

public interface StrategyLists 
{
	public ArrayList<Moviedisplayformat> fetchMovies(long uID);
	public void addMovie(SuperMovie movie);
	public void removeMovie(SuperMovie movie);

}
