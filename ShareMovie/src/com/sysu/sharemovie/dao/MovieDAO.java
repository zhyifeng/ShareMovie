package com.sysu.sharemovie.dao;

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
	
}
