package com.sysu.sharemovie.action.tag;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.opensymphony.xwork2.ModelDriven;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.MovieListDAO;
import com.sysu.sharemovie.dao.TagDAO;
import com.sysu.sharemovie.jdo.MovieList;
import com.sysu.sharemovie.jdo.Tag;

@SuppressWarnings("serial")
public class addTag extends BaseAction implements ModelDriven<Tag>{
	private Tag tag = new Tag();
	
	private Long listID;
	
	public void setListID(Long listID) {
		this.listID = listID;
	}

	public Long getListID() {
		return listID;
	}
	
	@Override
	public Tag getModel() {
		return tag;
	}

	public String execute(){
		if (!loggedIn())
			return LOGIN;
		MovieListDAO listDAO = new MovieListDAO();
		TagDAO tagDAO = new TagDAO();
		listDAO.makeconnect();
		tagDAO.makeconnect();
		Key listkey=KeyFactory.createKey(MovieList.class.getSimpleName(), listID);
		MovieList list = listDAO.queryMovieListByID(listkey);
		Tag tag = tagDAO.queryTagByName(this.tag.getTagname());
		if (tag==null) {
			tagDAO.addTag(this.tag);
			tag=this.tag;
		}
		list.getMovieTag().add(tag.getKey());
		tag.getTaginmovielist().add(listkey);
		tagDAO.closeconnect();
		listDAO.closeconnect();
		this.addActionMessage("success");
		return SUCCESS;
	}
}
