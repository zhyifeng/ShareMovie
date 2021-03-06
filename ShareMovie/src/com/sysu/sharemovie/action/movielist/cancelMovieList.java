package com.sysu.sharemovie.action.movielist;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.dao.SMUserDAO;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.jdo.SMUser;

@SuppressWarnings("serial")
public class cancelMovieList extends BaseAction{
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
		SMUserDAO userDAO = new SMUserDAO();
		MovieListDAO listDAO = new MovieListDAO();
		userDAO.makeconnect();
		listDAO.makeconnect();
		Key userkey = (Key)getSession("userkey");
		Key listkey = KeyFactory.createKey(MovieList.class.getSimpleName(), Long.parseLong(listID));
		SMUser user = userDAO.querySMUserByID(userkey);
		MovieList list = listDAO.queryMovieListByID(listkey);
		System.out.println("username:"+user.getUsername());
		System.out.println("userkey:"+String.valueOf(user.getKey()));
		System.out.println("listkey:"+String.valueOf(list.getKey()));
		user.getCollectMovielist().remove(list.getKey());
		userDAO.closeconnect();
		listDAO.closeconnect();
		return SUCCESS;
	}
}
