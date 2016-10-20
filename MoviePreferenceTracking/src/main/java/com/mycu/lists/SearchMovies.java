package com.mycu.lists;

import java.util.ArrayList;
import com.mycu.dao.SearchDAO;
import com.mycu.model.Moviedisplayformat;
import com.mycu.model.Movie;

public class SearchMovies 
{
	public long mID,uID;
	public String movieTitle;
	public boolean wish,ignore;
	public int ratings;
	
	SearchDAO searchdao = new SearchDAO();
	ArrayList<Moviedisplayformat> formatmovies= new ArrayList<Moviedisplayformat>();
	
	public SearchMovies() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Moviedisplayformat> fetchMovies()
	{		
		formatmovies=formatMovies(searchdao.fetchMovies());
		return formatmovies;
	}

	public ArrayList<Moviedisplayformat> fetchMovies(String searchString)
	{
			
		formatmovies=formatMovies(searchdao.fetchMovies(searchString));	
		return formatmovies;
	}

	
	public ArrayList<Moviedisplayformat> formatMovies(ArrayList<Movie> movies)
	{
		for(Movie mov: movies)
		{		
			movieTitle=mov.getMovieTitle();
			ratings=0;
			wish= false;
			ignore=false;
				
			Moviedisplayformat formatmovie = new Moviedisplayformat(movieTitle,wish,ignore,ratings);
			formatmovies.add(formatmovie);
			
		}
		
		return formatmovies;
	}
	

}
