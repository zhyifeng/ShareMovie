package com.sysu.sharemovie.action.comment;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.opensymphony.xwork2.ModelDriven;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.CommentDAO;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.jdo.Comment;
import com.sysu.sharemovie.jdo.MovieList;

@SuppressWarnings("serial")
public class addComment extends BaseAction implements ModelDriven<Comment>{
	private Comment comment = new Comment();
	
	private String listID;
	
	public void setListID(String listID) {
		this.listID = listID;
	}

	public String getListID() {
		return listID;
	}
	
	@Override
	public Comment getModel() {
		return comment;
	}
	
	public String execute(){
		if (!loggedIn())
			return LOGIN;
		MovieListDAO listDAO = new MovieListDAO();
		CommentDAO commentDAO = new CommentDAO();
		listDAO.makeconnect();
		commentDAO.makeconnect();
		Key userKey = (Key) getSession("userkey");
		Key listkey=KeyFactory.createKey(MovieList.class.getSimpleName(), Long.parseLong(listID));
		MovieList list = listDAO.queryMovieListByID(listkey);
		commentDAO.addComment(comment);
		list.getMovieComment().add(comment.getKey());
		comment.setAuthor(userKey);
		comment.setListkey(listkey);
		commentDAO.closeconnect();
		listDAO.closeconnect();
		this.addActionMessage("success");
		return SUCCESS;
	}

	
}
