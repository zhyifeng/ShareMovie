package com.sysu.sharemovie.action.tag;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	
	private String listID;
	
	public void setListID(String listID) {
		this.listID = listID;
	}

	public String getListID() {
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
		Key listkey=KeyFactory.createKey(MovieList.class.getSimpleName(), Long.parseLong(listID));
		MovieList list = listDAO.queryMovieListByID(listkey);
		Tag tagex = tagDAO.queryTagByName(tag.getTagname());
		if (tagex==null) {
			tagDAO.addTag(tag);
			Set<Key> taginmovielist = new HashSet<Key>();
			taginmovielist.add(list.getKey());
			tag.setTaginmovielist(taginmovielist);
			list.getMovieTag().add(tag.getKey());
		} else {
			Set<Key> taginmovielist = new HashSet<Key>();
			Iterator<Key> iter;
			iter  = tagex.getTaginmovielist().iterator();
			while (iter.hasNext()) {
				Key mlistkey = iter.next();
				taginmovielist.add(mlistkey);
				System.out.println("movielistkey"+String.valueOf(mlistkey));
			}
			taginmovielist.add(list.getKey());
			tagex.setTaginmovielist(taginmovielist);
			list.getMovieTag().add(tagex.getKey());
		}
		tagDAO.closeconnect();
		listDAO.closeconnect();
		this.addActionMessage("success");
		return SUCCESS;
	}
}
