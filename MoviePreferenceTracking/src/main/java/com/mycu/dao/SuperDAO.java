package com.mycu.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycu.dbhandler.HibernateUtil;
import com.mycu.model.SuperMovie;

public class SuperDAO 
{
	ArrayList<SuperMovie> movies = new ArrayList<SuperMovie>();

	 public Session beginSession()
	 {
		    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			return session;
	 }
	 public ArrayList<SuperMovie> getResults(String queried, long uID)
	 {
		 	Session session=beginSession();
		    Query query = session.createQuery(queried);
			query.setParameter("uID",uID);
		    
			@SuppressWarnings("unchecked")
			List<SuperMovie> allmovies = query.list();
			for(SuperMovie movie: allmovies)
			{
				movies.add(movie);
			}
			session.getTransaction().commit();	
			return movies;
	 }	 
	
	 public void removeEntry(String query1,String query2,long mID)
	 {
		 	Session session=beginSession();
		    Query query = session.createQuery(query1);
			query.setParameter("mID",mID);
			@SuppressWarnings("unchecked")
			List<SuperMovie> allmovies = query.list();
			for(SuperMovie movie: allmovies)
			{
				 query = session.createQuery(query2);
				 query.setParameter("mID",mID);
			}
			
		    
			session.getTransaction().commit();
	 }
}
