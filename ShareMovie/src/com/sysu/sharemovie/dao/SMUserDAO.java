package com.sysu.sharemovie.dao;

import java.util.List;

import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;
import com.sysu.sharemovie.jdo.SMUser;

public class SMUserDAO extends DAOSupport{

	public boolean addSMUser(SMUser user) throws Exception {
		//System.out.print(user.getUsername());
		if (isSMUserExit(user.getUsername()))
			return false;
//		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(user);
			return true;
		}finally{
//			pm.close();
		}
	}

	public boolean validateSMUser(SMUser user) throws Exception {
		SMUser result = querySMUser(user.getUsername());
		if (result!=null){
			if (user.getPassword().equals(result.getPassword())){
				return true;
			}
			else{
				return false;
			}
		}
		else{
		    return false;
		}
	}

	private boolean isSMUserExit(String username){
		if (querySMUser(username)!=null)
			return true;
		else
		    return false;
	}
	
	@SuppressWarnings("unchecked")
	public SMUser querySMUser(String username){
//		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(SMUser.class, "username == '"+username+"'");
		try{
			List<SMUser> result = (List<SMUser>)query.execute();
			if (result.size()==0)
				return null;
			else
				return result.get(0);
		}finally{
			query.closeAll();
//			pm.close();
		}
	}
	
	public SMUser querySMUserByID(Key userkey)
			throws Exception {
//		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			SMUser user = pm.getObjectById(SMUser.class, userkey);
			return user;
		}catch (Exception e) {
			return null;
		}finally{
//			pm.close();
		}
	}

}
