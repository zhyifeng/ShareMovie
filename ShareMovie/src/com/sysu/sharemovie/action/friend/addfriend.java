package com.sysu.sharemovie.action.friend;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.SMUserDAO;
import com.sysu.sharemovie.jdo.SMUser;

@SuppressWarnings("serial")
public class addFriend extends BaseAction{
	private String friendkey;

	public void setFriendkey(String friendkey) {
		this.friendkey = friendkey;
	}

	public String getFriendkey() {
		return friendkey;
	}

	
	public String execute() {
		if (!loggedIn())
			return LOGIN;
		SMUserDAO userDAO = new SMUserDAO();
		userDAO.makeconnect();
		Key userKey = (Key) getSession("userkey");
		Key key = KeyFactory.createKey(SMUser.class.getSimpleName(), Long.parseLong(friendkey));
		SMUser user = userDAO.querySMUserByID(userKey);
		SMUser friend = userDAO.querySMUserByID(key);
		user.getFriendlist().add(friend.getKey());
		friend.getFriendlist().add(user.getKey());
		userDAO.closeconnect();
		return SUCCESS;
	}
	
}
