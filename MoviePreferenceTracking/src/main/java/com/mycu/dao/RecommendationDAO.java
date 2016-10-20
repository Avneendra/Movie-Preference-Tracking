package com.mycu.dao;

import java.util.ArrayList;
import org.hibernate.Session;
import com.mycu.model.SuperMovie;
import com.mycu.model.Recommendation;


public class RecommendationDAO  extends SuperDAO implements StrategyDAO
{
	
	public long uID,mID;
	public int ratings;
	Recommendation rec = new Recommendation();

	public RecommendationDAO() 
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<SuperMovie> fetchMovies(long uID)
	{
		
		ArrayList<SuperMovie> movies = new ArrayList<SuperMovie>();		
		String queried="from Recommendation R where R.uID = :uID";
		movies=getResults(queried,uID);	
		return movies;
	}
	

	public void addMovie(SuperMovie movie)
	{
		
		mID=movie.getmID();
		uID=movie.getuID();
		ratings=movie.getRating();
		
		rec.setmID(mID);
		rec.setuID(uID);
		rec.setRatings(ratings);
		
		Session session=beginSession();
		
		session.saveOrUpdate(rec);
		session.getTransaction().commit();
	}
	
	public void removeMovie(SuperMovie movie)
	{	
		mID=movie.getmID();
		uID=movie.getuID();
		ratings=movie.getRating();
		String query1="from Recommendation Rc where Rc.mID = :mID";
		String query2="delete from Recommendation Rc where Rc.mID = :mID";
		
		removeEntry(query1,query2,mID);
	    	   
	}
	
	
}
