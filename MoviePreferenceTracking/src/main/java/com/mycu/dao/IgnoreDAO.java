package com.mycu.dao;

import java.util.ArrayList;
import org.hibernate.Session;
import com.mycu.model.SuperMovie;
import com.mycu.model.Ignore;


public class IgnoreDAO extends SuperDAO implements StrategyDAO
{
	public long uID,mID;
	public int ratings;
	
	Ignore ign = new Ignore();
	
	public IgnoreDAO() 
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<SuperMovie> fetchMovies(long uID)
	{
		System.out.println("Inside fetchMovies in ignore DAO");
		ArrayList<SuperMovie> movies = new ArrayList<SuperMovie>();
		
		String queried="from Ignore I where I.uID = :uID";
		movies=getResults(queried,uID);	
		
		return movies;
	}
	
	public void addMovie(SuperMovie movie)
	{
		mID=movie.getmID();
		uID=movie.getuID();
		ratings=movie.getRating();
		
		ign.setmID(mID);
		ign.setuID(uID);
		ign.setRatings(ratings);
		
		
		Session session=beginSession();
		session.saveOrUpdate(ign);
		session.getTransaction().commit();
	}
	
	public void removeMovie(SuperMovie movie)
	{
		System.out.println("Inside remove movie in Ignore DAO");
		mID=movie.getmID();
		
		String query1="from Ignore I where I.mID = :mID";
		String query2="delete from Ignore I where I.mID = :mID";
		
		removeEntry(query1,query2,mID);
		
	}
	
}
