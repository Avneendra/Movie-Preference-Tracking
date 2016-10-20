package com.mycu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.mycu.model.User;


public class UserDAO 
{
	private String Username,password;
	private String email,fName,lName;
	public long uID;
	
	SuperDAO superdao=new SuperDAO();
	
	public UserDAO()
	{
		
	}

	public long checkUser(User user)
	{
	    try
	    {
	    	 Session session=superdao.beginSession();    	 
	    	 Query query = session.createQuery("from User U where U.userName = :userName");
	    	 query.setParameter("userName",user.getuserName());
	         @SuppressWarnings("unchecked")
			 List<User> user2 = query.list();
	         for(User user3 : user2)
	         {
	             System.out.println("List of Users::"+user3.getuId()+","+user3.getfName());
	             if(user3.getpassword().equals(user.getpassword()) && user3.getuserName().equals(user.getuserName()))
	            	 uID=user3.getuId();
	             else
	            	 uID=0;
	         }
	     
	        session.getTransaction().commit();
	        
	    }catch (HibernateException e) 
	    {
	        e.printStackTrace();
	    }
	    return uID;
	}
	
	
	
	public long addUser(User user)
	{
		 Session session=superdao.beginSession();  
 		
 		 session.save(user);	
 		 session.getTransaction().commit();
 		 
		 
 		 uID=user.getuId();
 		 return uID;
	}
	
	
	public long save(User user)
	{
		Session session=superdao.beginSession();  	
 		
		lName=user.getlName();
 		fName=user.getfName();
 		email=user.getEmail();
 		Username=user.getuserName();
 		password=user.getpassword();
 		uID=user.getuId();
 		
 		User user2=new User();
 		
 		user2= (User) session.get(User.class,uID+1);
 		
 		user2.setfName(fName);
 		user2.setlName(lName);
 		user2.setEmail(email);
 		user2.setpassword(password);
 		user2.setuserName(Username);
 	
 		
 		session.update(user2);	
 		session.getTransaction().commit();
 		
 		
 		return uID;
	}
	
	public User getUser(long uID)
	{
		User user =new User();
		Session session=superdao.beginSession();  
		
		user= (User) session.get(User.class,uID);
		session.getTransaction().commit();
 		
		return user;
	}
}
