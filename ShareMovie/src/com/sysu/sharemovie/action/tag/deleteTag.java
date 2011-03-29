package com.sysu.sharemovie.action.tag;

import com.google.appengine.api.datastore.Key;
import com.opensymphony.xwork2.ModelDriven;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.dao.TagDAO;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.jdo.Tag;

@SuppressWarnings("serial")
public class deleteTag extends BaseAction implements ModelDriven<Tag>{
	private Tag tag = new Tag();
	
	private Key listkey;
	
	public void setListkey(Key listkey) {
		this.listkey=listkey;
	}
	
	@Override
	public Tag getModel() {
		return tag;
	}

	public String execute() {
		if (!loggedIn())
			return LOGIN;
		delTag(tag.getKey());
		return SUCCESS;
	}
	
	private void delTag(Key key) {
		TagDAO tagDAO = new TagDAO();
		MovieListDAO listDAO = new MovieListDAO();
		tagDAO.makeconnect();
		listDAO.makeconnect();
		Tag tag = tagDAO.queryTag(key);
		MovieList list = listDAO.queryMovieListByID(listkey);
		list.getMovieTag().remove(key);
		tag.getTaginmovielist().remove(listkey);
		tagDAO.closeconnect();
		listDAO.closeconnect();
	}

}
