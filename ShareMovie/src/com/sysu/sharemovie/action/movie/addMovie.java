package com.sysu.sharemovie.action.movie;

import com.google.appengine.api.datastore.Key;
import com.opensymphony.xwork2.ModelDriven;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.MovieDAO;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.jdo.Movie;
import com.sysu.sharemovie.jdo.MovieList;

@SuppressWarnings("serial")
public class addMovie extends BaseAction implements ModelDriven<Movie> {
	private Movie movie = new Movie();
	
	private Key listkey;
	
	public void setListkey(Key listkey) {
		this.listkey=listkey;
	}
	
	@Override
	public Movie getModel() {
		return movie;
	}

	public String execute(){
		if (!loggedIn())
			return LOGIN;
		MovieListDAO listDAO = new MovieListDAO();
		MovieDAO movieDAO = new MovieDAO();
		listDAO.makeconnect();
		movieDAO.makeconnect();
		Key userKey = (Key) getSession("userkey");
		MovieList list = listDAO.queryMovieListByID(listkey);
		if (list.getAuthor().compareTo(userKey)!=0){
			movieDAO.closeconnect();
			listDAO.closeconnect();
			return ERROR;
		}
		movieDAO.addmovie(movie);
		list.getMovieInList().add(movie.getKey());
		movie.setAuthor(userKey);
		movie.setListkey(listkey);
		movieDAO.closeconnect();
		listDAO.closeconnect();
		this.addActionMessage("success");
		return SUCCESS;
	}

}
