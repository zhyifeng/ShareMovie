package com.sysu.sharemovie.action.movielist;

import java.util.Iterator;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.action.comment.deleteComment;
import com.sysu.sharemovie.action.movie.deleteMovie;
import com.sysu.sharemovie.action.tag.deleteTag;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.dao.SMUserDAO;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.jdo.SMUser;

@SuppressWarnings("serial")
public class deleteMovieList extends BaseAction {
	private String listID;
	
	public void setListID(String listID) {
		this.listID = listID;
	}

	public String getListID() {
		return listID;
	}

	public String execute() {
		if (!loggedIn())
			return LOGIN;
		Key listkey=KeyFactory.createKey(MovieList.class.getSimpleName(), Long.parseLong(listID));
		MovieListDAO listDAO = new MovieListDAO();
		listDAO.makeconnect();
		MovieList list = listDAO.queryMovieListByID(listkey);
		listDAO.closeconnect();
		if (list.getAuthor().compareTo((Key) getSession("userkey"))!=0)
			return ERROR;
		delMovieList(list.getKey());
		return SUCCESS;
	}
	
	public boolean delMovieList(Key key)
	{
		SMUserDAO userDAO = new SMUserDAO();
		MovieListDAO listDAO = new MovieListDAO();
		userDAO.makeconnect();
		listDAO.makeconnect();
		MovieList list = listDAO.queryMovieListByID(key);
		SMUser author = userDAO.querySMUserByID(list.getAuthor());
		author.getUserMovielist().remove(list.getKey());
		Iterator<Key> i;
		i = list.getMovieInList().iterator();
		deleteMovie delMov = new deleteMovie();
		for (;i.hasNext();) {
			delMov.delMovie(i.next());
		}
		i = list.getMovieComment().iterator();
		deleteComment delCom = new deleteComment();
		for (;i.hasNext();) {
			delCom.delComment(i.next());
		}
		i = list.getMovieTag().iterator();
		deleteTag delTag = new deleteTag();
		for (;i.hasNext();) {
			delTag.delTag(i.next(), key);
		}
		listDAO.deleteMovieList(key);
		userDAO.closeconnect();
		listDAO.closeconnect();
		return true;
	}

}
