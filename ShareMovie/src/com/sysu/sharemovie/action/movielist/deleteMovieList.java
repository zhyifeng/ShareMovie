package com.sysu.sharemovie.action.movielist;

import com.google.appengine.api.datastore.Key;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.dao.SMUserDAO;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.jdo.SMUser;

public class deleteMovieList extends BaseAction {
	private Key key;
	
	public void setKey(Key key) {
		this.key=key;
	}
	
	public String execute() {
		if (!loggedIn())
			return LOGIN;
		SMUserDAO userDAO = new SMUserDAO();
		MovieListDAO listDAO = new MovieListDAO();
		userDAO.makeconnect();
		listDAO.makeconnect();
		Key userKey = (Key) getSession("userkey");
		SMUser user = userDAO.querySMUserByID(userKey);
		MovieList list = listDAO.queryMovieListByID(key);
		if (list.getOwner()!=userKey){
			userDAO.closeconnect();
			listDAO.closeconnect();
			return INPUT;
		}
		user.getUserMovielist().remove(list.getKey());
		
		listDAO.deleteMovieList(list.getKey());
		return SUCCESS;
	}
	
}
