package com.sysu.sharemovie.action.movie;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.MovieDAO;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.jdo.Movie;
import com.sysu.sharemovie.jdo.MovieList;

@SuppressWarnings("serial")
public class deleteMovie extends BaseAction {
	private String movieID;
	
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

	public String getMovieID() {
		return movieID;
	}

	public String execute() {
		if (!loggedIn())
			return LOGIN;
		Key moviekey=KeyFactory.createKey(Movie.class.getSimpleName(), Long.parseLong(movieID));
		MovieDAO movieDAO = new MovieDAO();
		movieDAO.makeconnect();
		Movie movie = movieDAO.queryMovieInMovieList(moviekey);
		movieDAO.closeconnect();
		if (movie.getAuthor().compareTo((Key) getSession("userkey"))!=0)
			return ERROR;
		delMovie(movie.getKey());
		return SUCCESS;
	}

	public boolean delMovie(Key key) {
		MovieDAO movieDAO = new MovieDAO();
		MovieListDAO listDAO = new MovieListDAO();
		movieDAO.makeconnect();
		listDAO.makeconnect();
		Movie movie = movieDAO.queryMovieInMovieList(key);
		MovieList list = listDAO.queryMovieListByID(movie.getListkey());
		list.getMovieInList().remove(key);
		movieDAO.deleteMovie(key);
		movieDAO.closeconnect();
		listDAO.closeconnect();
		return true;
	}
}
