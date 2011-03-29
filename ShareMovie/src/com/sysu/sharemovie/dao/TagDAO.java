package com.sysu.sharemovie.dao;

import java.util.List;

import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;
import com.sysu.sharemovie.jdo.Tag;

public class TagDAO extends DAOSupport{
	
	public boolean addTag(Tag tag) {
		try{
			pm.makePersistent(tag);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean deleteTag(Key tagkey) {
		try{
			Tag tag = pm.getObjectById(Tag.class, tagkey);
			pm.deletePersistent(tag);
			return true;
		}catch (Exception e) {
			return false;
		}		
	}
	
	public Tag queryTag(Key tagkey){
		try{
			Tag tag = pm.getObjectById(Tag.class, tagkey);
			return tag;
		}catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Tag queryTagByName(String tagname){
		Query query = pm.newQuery(Tag.class, "tagname == '"+tagname+"'");
		try{
			List<Tag> result = (List<Tag>)query.execute();
			if (result.size()==0)
				return null;
			else
				return result.get(0);
		}finally{
			query.closeAll();
		}
	}
}
 