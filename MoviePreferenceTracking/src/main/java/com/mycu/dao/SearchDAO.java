package com.mycu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycu.dbhandler.HibernateUtil;

import com.mycu.model.Movie;

public class SearchDAO 
{

	public SearchDAO() 
	{
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Movie> fetchMovies()
	{
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Movie");
		@SuppressWarnings("unchecked")
		List<Movie> allmovies = query.list();
		
		for(Movie mov: allmovies)
			movies.add(mov);
		
		session.getTransaction().commit();	
		
		return movies;
	}
	
	public ArrayList<Movie> fetchMovies(String searchString)
	{
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
			
		
		Query query = session.createQuery("from Movie M where M.movieTitle LIKE :searchString");
		query.setParameter("searchString",searchString+ "%");
		@SuppressWarnings("unchecked")
		List<Movie> allmovies = query.list();
		
		for(Movie mov: allmovies)
			movies.add(mov);
		
		session.getTransaction().commit();	
		
		return movies;
	}
	
	
}
