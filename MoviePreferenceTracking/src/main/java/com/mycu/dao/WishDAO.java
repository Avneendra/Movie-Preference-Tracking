package com.mycu.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import com.mycu.model.SuperMovie;

import com.mycu.model.Wish;


public class WishDAO extends SuperDAO  implements StrategyDAO
{
	public long uID,mID;
	public int ratings;
	Wish wsh = new Wish();
	@Override
	public ArrayList<SuperMovie> fetchMovies(long uID)
	{
		System.out.println("Inside fetchMovies in Wish DAO");
		ArrayList<SuperMovie> movies = new ArrayList<SuperMovie>();
		String queried="from Wish W where W.uID = :uID";
		
		movies=getResults(queried,uID);	
		
		return movies;
	}
	public void addMovie(SuperMovie movie)
	{		
		
		mID=movie.getmID();
		uID=movie.getuID();
		ratings=movie.getRating();

		wsh.setmID(mID);
		wsh.setuID(uID);
		wsh.setRatings(ratings);
		
		Session session=beginSession();	
		
		session.saveOrUpdate(wsh);
		session.getTransaction().commit();
	}
	
	public void removeMovie(SuperMovie movie)
	{
		mID=movie.getmID();
		
		String query1="from Wish W where W.mID = :mID";
		String query2="delete from Wish W where W.mID = :mID";
		//removeEntry(query1,query2,mID);
		Session session=beginSession();
		 Query query = session.createQuery(query1);
		query.setParameter("mID",mID);
		if(query.uniqueResult()!=null)
		{
				
				query=session.createQuery(query2);
				query.setParameter("mID", mID);
		}
		    
			session.getTransaction().commit();
	}
	


}
