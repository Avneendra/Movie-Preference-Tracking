package com.mycu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;

import com.mycu.dao.UserDAO;
import com.mycu.lists.ContextLists;
import com.mycu.lists.IgnoreList;
import com.mycu.lists.MovieListWrapper;
import com.mycu.lists.RatingsList;
import com.mycu.lists.RecommendationLists;
import com.mycu.lists.SearchMovies;
import com.mycu.lists.WishList;
import com.mycu.model.SuperMovie;
//import javax.persistence.Query;
import com.mycu.model.*;


@Controller
public class HomeController 
{
	
	private String Username,Password;
	private String email,fName,lName;
	public  long uID,mID;
	public String page;
	public int ratings;
	
	UserDAO userdao= new UserDAO();
	User usernew= new User(); 
	ArrayList<Moviedisplayformat> movies= new ArrayList<Moviedisplayformat>();
	SuperMovie supermovie =new SuperMovie();
	
	
	// When user clicks on edit profile
	@RequestMapping(value = "/editprofile")
    public ModelAndView  viewProfile(@ModelAttribute("userForm") User user,ModelMap model)
    {
    	 return new ModelAndView("viewprofile", "user", new User(fName,lName,Username,email,Password));
    }
    
   
	
	 @RequestMapping(value = "/Search")
	 public String Search(ModelMap model) 
	 {		
		 page=displaySearch(model,uID);
	     return page;
	 }
	 
	 
	 
	 @RequestMapping(value = "/SearchString" ,method = RequestMethod.POST)
	 public String SearchString(ModelMap model,@RequestParam(value = "Search", required = false) String searchquery) 
	 {
		 System.out.println("String entered is "+ searchquery);
		 
		 page=displaySearchresult(model,uID,searchquery);
	     return page;
	 }
	 
	 
	 
	 @RequestMapping(value = "/MyLists-Ratings")
	 public String myLists(ModelMap model)  //By default ratings page
	 {				 
    	 page=displayRatings(model,uID);
	     return page;
	 }
	 
	 
	 
	 
	 @RequestMapping(value = "/Ignore")
	 public String myIgnoreList(ModelMap model)  
	 {
		page=displayIgnore(model,uID);
	    return page; 
	 }
	
	 	 
	 
	 @RequestMapping(value = "/Wish")
	 public String myWishlist(ModelMap model) 
	 {
		//uID=usernew.getuId();	
		page=displayWish(model,uID);
	    return page;  
	 }
	 	 
	 
	 
	 @RequestMapping(value = "/dbupdate", method = RequestMethod.POST)
	 public String dbUpdate(@ModelAttribute("movieListWrapper") MovieListWrapper movies,ModelMap model,@RequestParam String action) 
	 {
		   MovieController moviecontroller= new MovieController();
		   ContextLists contextIgnore = new ContextLists(new IgnoreList());
		   ContextLists contextWish = new ContextLists(new WishList());
		   ContextLists contextRating = new ContextLists(new RatingsList());
		   
		   
		    if(action.equals("Save"))  // Save changes to the database
	    	{	
		    	  ArrayList<Moviedisplayformat> moviesondisplay = movies.getAllmovies(); 
				    for(Moviedisplayformat mdf: moviesondisplay)
				    {
				    	mID=moviecontroller.getMID(mdf.getMovieTitle());
				    	supermovie.setmID(mID);
			    		supermovie.setuID(uID);
			    		supermovie.setRatings(mdf.getRatings());
				    	
				    	
				    	if(mdf.isIgnore()==true)
				    	{ 	 
				    		
				    		contextIgnore.executeAddMovieStrategy(supermovie);
				    	 	contextWish.executeRemoveMovieStrategy(supermovie); 	 	
				    	 	contextRating.executeRemoveMovieStrategy(supermovie);	    		
				    		
				    	}
				    	if(mdf.isWish()==true)
				    	{
				    		
				    	 	contextWish.executeAddMovieStrategy(supermovie);  	 	
				    	 	contextIgnore.executeRemoveMovieStrategy(supermovie);
				    	 	contextRating.executeRemoveMovieStrategy(supermovie);
				    		
				    	}
				    	if(mdf.ratings>1)
				    	{
				    				    		
				    		contextRating.executeAddMovieStrategy(supermovie);			
				    		contextIgnore.executeRemoveMovieStrategy(supermovie);
				    		contextWish.executeRemoveMovieStrategy(supermovie);
				    					    		
				    	}
				    			    		
				    	/*System.out.println("Title is "+ mdf.getMovieTitle());
				    	System.out.println("Ignore value is "+ mdf.isIgnore());
				    	System.out.println("Wish value is "+ mdf.isWish());
				    	System.out.println("Ratings is "+ mdf.getRatings());*/
				    }
		  		
	    	}	    
		    
		    page=displayRecommendation(model,uID);
	    	return page;
	   }
	 
		
	 
	    @RequestMapping(value = "/profile")
	    public String profile(@ModelAttribute("userForm") User user,ModelMap model,@RequestParam String action)
	    {
	    	    	
	    	if(action.equals("Save"))  // Save changes to the database
	    	{
	    		uID=userdao.save(user);
	    		user=userdao.getUser(uID);	    		   		
	    	}
	    	else // cancel changes
	    	{
	    		user=userdao.getUser(uID);		
	    	}
	    	
	    	usernew=user;
	    	page=displayRecommendation(model,uID);
	    	return page;
	   
	    }

	    
	        
	    
	    public String displayRecommendation(ModelMap model, long uID)
	    {
	    	 MovieListWrapper wrapper=new MovieListWrapper();
	    	 ContextLists context = new ContextLists(new RecommendationLists());
			 
	    	 movies=context.executeFetchMovieStrategy(uID);
			 wrapper.setAllmovies(movies);
			 
			 model.addAttribute("fName",usernew.getfName());
			 model.addAttribute("movies", movies);
	    	 return "userLoggedin"; //recommendations page
	    }
	    
	    
	    
	    
	    public String displayRatings(ModelMap model, long uID)
	    {
	    	 ContextLists context = new ContextLists(new RatingsList());
			 
	    	 movies=context.executeFetchMovieStrategy(uID);
			
	    	 model.addAttribute("fName",usernew.getfName());
			 model.addAttribute("movies", movies);
	    	 return "MyLists"; //ratings page
	    }
	    
	    
	    
	    
	    public String displayIgnore(ModelMap model, long uID)
	    {
	    	 ContextLists context = new ContextLists(new IgnoreList());	 
	    	 movies=context.executeFetchMovieStrategy(uID);
	    	 	 		
			 model.addAttribute("fName",usernew.getfName());
			 model.addAttribute("movies", movies);
	    	 return "ignoreList"; //ignore list page
	    }
	    
	    
	    
	    
	    public String displayWish(ModelMap model, long uID)
	    {
	    	 ContextLists context = new ContextLists(new WishList());
			 movies=context.executeFetchMovieStrategy(uID);
			 		 
			 model.addAttribute("fName",usernew.getfName());
			 model.addAttribute("movies", movies);
	    	 return "Wishlist"; //wish list page
	    }
	    
	    public String displaySearchresult(ModelMap model,long uID, String searchString)
	    {
	    	 MovieListWrapper wrapper=new MovieListWrapper();
			 SearchMovies search = new SearchMovies();
			 movies=search.fetchMovies(searchString);
			 wrapper.setAllmovies(movies);
			 	 
			 model.addAttribute("fName",usernew.getfName());
			 model.addAttribute("movieListWrapper",wrapper);
			 
	    	 return "Search"; //Search page
	    }
	    
	    
	    
	    public String displaySearch(ModelMap model, long uID)
	    {    	 
	    	
	    	 MovieListWrapper wrapper=new MovieListWrapper();
			 SearchMovies search = new SearchMovies();
	    	 
	    	 movies=search.fetchMovies();   	 
			 wrapper.setAllmovies(movies);
			 
			 model.addAttribute("fName",usernew.getfName());
			 model.addAttribute("movieListWrapper",wrapper); 
	    	 return "Search"; //Search page
	    }
	    
	    
	  
	
	    
}
