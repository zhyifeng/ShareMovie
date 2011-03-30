package com.sysu.sharemovie.action.movie;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
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
	private Long listID;

	public void setListID(Long listID) {
		this.listID = listID;
	}

	public Long getListID() {
		return listID;
	}

	public void setListkey(Key listkey) {
		this.listkey=listkey;
	}
	
	
	
	@Override
	public Movie getModel() {
		return movie;
	}

	public String execute(){
		if (!loggedIn()){
			this.addActionMessage("需要登录，才能继续操作");
			return LOGIN;
		}		
		MovieListDAO listDAO = new MovieListDAO();
		MovieDAO movieDAO = new MovieDAO();
		listDAO.makeconnect();
		movieDAO.makeconnect();
		Key userKey = (Key) getSession("userkey");
		System.out.println(listID);
		listkey=KeyFactory.createKey(MovieList.class.getSimpleName(), listID);
		MovieList list = listDAO.queryMovieListByID(listkey);
		if (list.getAuthor().compareTo(userKey)!=0){
			movieDAO.closeconnect();
			listDAO.closeconnect();
			this.addActionError("非法操作");
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
