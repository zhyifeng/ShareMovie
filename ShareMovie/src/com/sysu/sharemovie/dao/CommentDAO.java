package com.sysu.sharemovie.dao;

import com.google.appengine.api.datastore.Key;
import com.sysu.sharemovie.jdo.Comment;

public class CommentDAO extends DAOSupport{
	
	public boolean addComment(Comment comment) {
		try{
			pm.makePersistent(comment);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public Comment queryComment(Key commentkey) {
		try{
			Comment comment = pm.getObjectById(Comment.class, commentkey);
			return comment;
		}catch (Exception e) {
			return null;
		}	
	}
	
	public boolean deteleComment(Key commentkey) {
		try{
			Comment comment = pm.getObjectById(Comment.class, commentkey);
			pm.deletePersistent(comment);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
