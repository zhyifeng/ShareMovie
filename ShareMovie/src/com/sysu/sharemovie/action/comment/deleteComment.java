package com.sysu.sharemovie.action.comment;

import com.google.appengine.api.datastore.Key;
import com.opensymphony.xwork2.ModelDriven;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.CommentDAO;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.dao.SMUserDAO;
import com.sysu.sharemovie.jdo.Comment;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.jdo.SMUser;

@SuppressWarnings("serial")
public class deleteComment extends BaseAction implements ModelDriven<Comment>{
	private Comment comment = new Comment();
	
	@Override
	public Comment getModel() {
		return comment;
	}
	
	public String execute() {
		if (!loggedIn())
			return LOGIN;
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
