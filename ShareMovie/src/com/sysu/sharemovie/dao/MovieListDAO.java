package com.sysu.sharemovie.dao;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.dao.DAOSupport;

public class MovieListDAO extends DAOSupport{

	public boolean addMovieList(MovieList movielist) {
//		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(movielist);
			return true;
		}catch (Exception e) {
			return false;
		}
		finally{
			//pm.close();
		}
	}

	public MovieList queryMovieListByID(Key movielistkey){
//		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			MovieList list = pm.getObjectById(MovieList.class, movielistkey);
			return list;
		}catch (Exception e) {
			return null;
		}finally{
			//pm.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MovieList> queryAllMovieList() {
		Query query = pm.newQuery("select from " +MovieList.class.getName());
		try{
			List<MovieList> result = new ArrayList<MovieList>();
			result = (List<MovieList>)query.execute();
			result.size();
			return result;
		}catch (Exception e) {
			return null;
		}finally{
			query.closeAll();
		}
	}
    
	public boolean deleteMovieList(Key movielistkey) {
		try{
			MovieList list = pm.getObjectById(MovieList.class, movielistkey);
			pm.deletePersistent(list);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
