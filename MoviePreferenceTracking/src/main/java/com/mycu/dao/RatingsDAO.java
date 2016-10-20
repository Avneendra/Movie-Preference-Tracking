package com.mycu.dao;

import java.util.ArrayList;
import org.hibernate.Session;
import com.mycu.model.SuperMovie;
import com.mycu.model.Ratings;



public class RatingsDAO  extends SuperDAO implements StrategyDAO
{
	public long uID,mID;
	public int ratings;
	
	Ratings rate = new Ratings();
	public RatingsDAO() 
	{
		// TODO Auto-generated constructor stub
	}
	@Override
	public ArrayList<SuperMovie> fetchMovies(long uID)
	{
		System.out.println("Inside fetchMovies in RatingsDAO");
		ArrayList<SuperMovie> movies = new ArrayList<SuperMovie>();
		String queried="from Ratings R where R.uID = :uID";
		
		movies=getResults(queried,uID);		
		return movies;
	}
	
	public void addMovie(SuperMovie movie)
	{
		
		mID=movie.getmID();
		uID=movie.getuID();
		ratings=movie.getRating();
		
		rate.setmID(mID);
		rate.setuID(uID);
		rate.setRatings(ratings);
		
		Session session=beginSession();
		session.saveOrUpdate(rate);
		session.getTransaction().commit();
	}
	
	public void removeMovie(SuperMovie movie)
	{
	
		mID=movie.getmID();
	
		String query1="from Ratings R where R.mID = :mID";
		String query2="delete from Ratings R where R.mID = :mID";
		removeEntry(query1,query2,mID);
		
	}
	
	
}
