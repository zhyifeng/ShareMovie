package com.sysu.sharemovie.action.tag;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.dao.TagDAO;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.jdo.Tag;

@SuppressWarnings("serial")
public class deleteTag extends BaseAction {
	private Long tagID;
	private Long listID;
	

	public void setListID(Long listID) {
		this.listID = listID;
	}

	public Long getListID() {
		return listID;
	}

	public void setTagID(Long tagID) {
		this.tagID = tagID;
	}

	public Long getTagID() {
		return tagID;
	}

	public String execute() {
		if (!loggedIn())
			return LOGIN;
		Key tagkey=KeyFactory.createKey(Tag.class.getSimpleName(), tagID);
		Key listkey=KeyFactory.createKey(MovieList.class.getSimpleName(), listID);
		delTag(tagkey,listkey);
		return SUCCESS;
	}
	
	public void delTag(Key tagkey,Key listkey) {
		TagDAO tagDAO = new TagDAO();
		MovieListDAO listDAO = new MovieListDAO();
		tagDAO.makeconnect();
		listDAO.makeconnect();
		Tag tag = tagDAO.queryTag(tagkey);
		MovieList list = listDAO.queryMovieListByID(listkey);
		list.getMovieTag().remove(tagkey);
		tag.getTaginmovielist().remove(listkey);
		tagDAO.closeconnect();
		listDAO.closeconnect();
	}

}
