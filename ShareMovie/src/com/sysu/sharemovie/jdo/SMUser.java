package com.sysu.sharemovie.jdo;

import java.util.Date;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class SMUser {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String username;
	
	@Persistent
	private String password;
	
	@Persistent
	private String email;
	
	@Persistent
	private Date birthday;
	
	@Persistent
	private String address;
	
	@Persistent
	private char sex;
	
	@Persistent
	private Set<Key> friendlist;
	
	@Persistent
	private Set<Key> userMovielist;
	
	@Persistent
	private Set<Key> collectMovielist; /**/
	
	@Persistent
	private Set<Key> userComments;
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Set<Key> getFriendlist() {
		return friendlist;
	}

	public void setFriendlist(Set<Key> friendlist) {
		this.friendlist = friendlist;
	}

	public Set<Key> getUserMovielist() {
		return userMovielist;
	}

	public void setUserMovielist(Set<Key> userMovielist) {
		this.userMovielist = userMovielist;
	}

	public Set<Key> getUserComments() {
		return userComments;
	}

	public void setUserComments(Set<Key> userComments) {
		this.userComments = userComments;
	}

	public void setCollectMovielist(Set<Key> collectMovielist) {
		this.collectMovielist = collectMovielist;
	}

	public Set<Key> getCollectMovielist() {
		return collectMovielist;
	}

}
