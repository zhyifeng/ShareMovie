package com.sysu.sharemovie.action.movielist;

import java.util.Set;

import com.google.appengine.api.datastore.Key;
import com.opensymphony.xwork2.ModelDriven;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.jdo.SMUser;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.dao.SMUserDAO;

@SuppressWarnings("serial")
public class addMovieList extends BaseAction implements ModelDriven<MovieList>{
	private MovieList list= new MovieList();
	
	@Override
	public MovieList getModel() {
		return list;
	}


	public String execute(){
		if (!loggedIn())
			return LOGIN;
		MovieListDAO listDAO = new MovieListDAO();
		SMUserDAO userDAO = new SMUserDAO();
		listDAO.makeconnect();
		userDAO.makeconnect();
		Key userKey = (Key) getSession("userkey");
		// System.out.println(userKey.toString());
		listDAO.addMovieList(list);
		// System.out.println(list.getKey().toString());
		SMUser user = userDAO.querySMUserByID(userKey);
		user.getUserMovielist().add(list.getKey());
		// user.setUserMovielist(userMovieList);
		list.setOwner(userKey);
		userDAO.closeconnect();
		listDAO.closeconnect();
		this.addActionMessage("success");
		return SUCCESS;
	}
	
}
