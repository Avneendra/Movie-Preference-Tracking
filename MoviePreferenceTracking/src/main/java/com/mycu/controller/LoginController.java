package com.mycu.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycu.dao.UserDAO;
import com.mycu.lists.ContextLists;
import com.mycu.lists.MovieListWrapper;
import com.mycu.lists.RecommendationLists;
import com.mycu.model.Moviedisplayformat;
import com.mycu.model.SuperMovie;
import com.mycu.model.User;

@Controller
public class LoginController 
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
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	 public String Splashpage(@ModelAttribute("userForm") User user,ModelMap model) 
	 {
		    page=displaySplash();
	        return page;
	 }
    	
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView createAccount (@ModelAttribute("userForm") User user,ModelMap model)
    {
    	 return new ModelAndView("createaccount", "user", new User(fName,lName,Username,email,Password));
    }
    
	
	
	
	// When user tries to log in
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(@ModelAttribute("userForm") User user,BindingResult result,ModelMap model) 
    {
		
    	uID=userdao.checkUser(user);
   
    	if(uID==0)
    		page=displaySplash();
    	else
    	   page=displayRecommendation(model,uID);
    	
    	 
    	 usernew=userdao.getUser(uID);
    	 return page;

    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Recommendation(ModelMap model) 
    {
		usernew=userdao.getUser(uID);
		page=displayRecommendation(model,uID);
    	return page;

    }
	
	// When user created an account and clicked on submit
	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public String addUseraccount(@ModelAttribute("userForm") User user,ModelMap model) throws SQLException
    {

		uID=userdao.addUser(user); 	
		usernew=user;
		page=displaySplash();
        return page;
    }
	
	// When user tries to log out
	@RequestMapping(value = "/logout")
    public String userLogout(@ModelAttribute("userForm") User user,ModelMap model)
    {
		page=displaySplash();
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
    
    public String displaySplash()
    {
    	return "index";
    }

}
