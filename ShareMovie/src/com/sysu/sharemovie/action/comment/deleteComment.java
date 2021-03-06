package com.sysu.sharemovie.action.comment;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.CommentDAO;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.dao.SMUserDAO;
import com.sysu.sharemovie.jdo.Comment;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.jdo.SMUser;

@SuppressWarnings("serial")
public class deleteComment extends BaseAction{
	private String commentID;
	private String listID;
	
	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}

	public String getCommentID() {
		return commentID;
	}
	
	public void setListID(String listID) {
		this.listID = listID;
	}

	public String getListID() {
		return listID;
	}

	public String execute() {
		if (!loggedIn())
			return LOGIN;
		Key commentkey=KeyFactory.createKey(Comment.class.getSimpleName(), Long.parseLong(commentID));
		CommentDAO commentDAO = new CommentDAO();
		commentDAO.makeconnect();
		Comment comment = commentDAO.queryComment(commentkey);
		commentDAO.closeconnect();
		if (comment.getAuthor().compareTo((Key) getSession("userkey"))!=0)
			return ERROR;
		delComment(comment.getKey());
		return SUCCESS;
	}

	public boolean delComment(Key key) {
		CommentDAO commentDAO = new CommentDAO();
		MovieListDAO listDAO = new MovieListDAO();
		SMUserDAO userDAO = new SMUserDAO();
		commentDAO.makeconnect();
		listDAO.makeconnect();
		userDAO.makeconnect();
		Comment comment = commentDAO.queryComment(key);
		MovieList list = listDAO.queryMovieListByID(comment.getListkey());
		SMUser author = userDAO.querySMUserByID(comment.getAuthor());
		list.getMovieComment().remove(key);
		author.getUserComments().remove(key);
		commentDAO.deteleComment(key);
		commentDAO.closeconnect();
		listDAO.closeconnect();
		userDAO.closeconnect();
		return true;
	}
}
