package com.mycu.dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.mycu.model.Movie;

public class MovieDAO 
{
	public String movieTitle;
	public long mID;
	Movie movie = new Movie();
	
	SuperDAO superdao=new SuperDAO();
	public MovieDAO()
	{
		
	}

	
	public String getMovie(long mID)
	{
		Session session=superdao.beginSession(); 
 		
 		movie=(Movie) session.get(Movie.class,mID);
 		movieTitle=movie.getMovieTitle();
 		
		session.getTransaction().commit();
		
		return movieTitle;
	}
	
	public long getMID(String movieTitle)
	{
		Session session=superdao.beginSession(); 
		
		Query query = session.createQuery("from Movie M where M.movieTitle = :movieTitle");
		query.setParameter("movieTitle",movieTitle);
		
		@SuppressWarnings("unchecked")
		List<Movie> allmovies = query.list();
		for(Movie movie: allmovies)
		{
			mID=movie.getmID();
		}
		
		session.getTransaction().commit();
		
		return mID;
	}
}
