package com.sysu.sharemovie.dao;

import com.google.appengine.api.datastore.Key;
import com.sysu.sharemovie.jdo.Movie;

public class MovieDAO extends DAOSupport{
	
	public boolean addmovie(Movie movie){
		try{
		    pm.makePersistent(movie);
		    return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public Movie queryMovieInMovieList(Key moviekey){
		try{
			Movie movie = pm.getObjectById(Movie.class,moviekey);
			return movie;
		}catch (Exception e) {
			return null;
		}		
	}
	
	public boolean deleteMovie(Key moviekey) {
		try{
			Movie movie = pm.getObjectById(Movie.class,moviekey);
			pm.deletePersistent(movie);
			return true;
		}catch (Exception e) {
			return false;
		}		
	}
}
