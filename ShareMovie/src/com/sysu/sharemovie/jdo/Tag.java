package com.sysu.sharemovie.jdo;

import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Tag {
	@PrimaryKey
	@Persistent()
	private Key key;
	
	@Persistent
	private String tagname;
	
	@Persistent
	private Set<Key> taginmovielist;
    
	
	public Tag(String tagname, Set<Key> taginmovielist) {
		super();
		this.tagname = tagname;
		this.taginmovielist = taginmovielist;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public Set<Key> getTaginmovielist() {
		return taginmovielist;
	}

	public void setTaginmovielist(Set<Key> taginmovielist) {
		this.taginmovielist = taginmovielist;
	}
    
	
}
