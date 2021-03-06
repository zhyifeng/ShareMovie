package com.sysu.sharemovie.action.movielist;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.dao.SMUserDAO;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.jdo.SMUser;

@SuppressWarnings("serial")
public class collectMovieList extends BaseAction{
	private String listID;

	public void setListID(String listID) {
		this.listID = listID;
	}

	public String getListID() {
		return listID;
	}
	
	public String execute() {
		if (!loggedIn())
			return INPUT;
		MovieListDAO listDAO = new MovieListDAO();
		SMUserDAO userDAO = new SMUserDAO();
		listDAO.makeconnect();
		userDAO.makeconnect();
		Key userkey = (Key)getSession("userkey");
		Key listkey = KeyFactory.createKey(MovieList.class.getSimpleName(), Long.parseLong(listID));
		SMUser user = userDAO.querySMUserByID(userkey);
		System.out.println("username:"+user.getUsername());
		System.out.println("userkey:"+user.getKey());
		MovieList movielist = listDAO.queryMovieListByID(listkey);
		System.out.println("listkey:"+String.valueOf(movielist.getKey()));
		user.getCollectMovielist().add(movielist.getKey());
		listDAO.closeconnect();
		userDAO.closeconnect();
		return SUCCESS;
	}
}
