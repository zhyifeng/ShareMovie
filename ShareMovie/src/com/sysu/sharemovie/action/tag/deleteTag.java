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
	private String tagID;
	private String listID;
	

	public void setListID(String listID) {
		this.listID = listID;
	}

	public String getListID() {
		return listID;
	}

	public void setTagID(String tagID) {
		this.tagID = tagID;
	}

	public String getTagID() {
		return tagID;
	}

	public String execute() {
		if (!loggedIn())
			return LOGIN;
		Key tagkey=KeyFactory.createKey(Tag.class.getSimpleName(), Long.parseLong(tagID));
		Key listkey=KeyFactory.createKey(MovieList.class.getSimpleName(), Long.parseLong(listID));
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
		if (tag.getTaginmovielist().size() == 0) {
			tagDAO.deleteTag(tag.getKey());
		}
		tagDAO.closeconnect();
		listDAO.closeconnect();
	}

}
