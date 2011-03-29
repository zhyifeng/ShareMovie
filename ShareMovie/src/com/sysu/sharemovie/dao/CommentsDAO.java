package com.sysu.sharemovie.dao;

import com.google.appengine.api.datastore.Key;
import com.sysu.sharemovie.jdo.Comments;

public class CommentsDAO extends DAOSupport{
	
	public boolean addComment(Comments comment) {
		try{
			pm.makePersistent(comment);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public Comments queryComment(Key commentkey) {
		try{
			Comments comment = pm.getObjectById(Comments.class, commentkey);
			return comment;
		}catch (Exception e) {
			return null;
		}	
	}
	
	public boolean deteleComment(Key commentkey) {
		try{
			Comments comment = pm.getObjectById(Comments.class, commentkey);
			pm.deletePersistent(comment);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
