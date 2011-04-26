package com.sysu.sharemovie.action.friend;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.SMUserDAO;
import com.sysu.sharemovie.jdo.SMUser;

@SuppressWarnings("serial")
public class deleteFriend extends BaseAction{
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
		Key userkey = (Key)getSession("userkey");
		Key key = KeyFactory.createKey(SMUser.class.getSimpleName(), Long.parseLong(friendkey));
		SMUser user = userDAO.querySMUserByID(userkey);
		SMUser friend = userDAO.querySMUserByID(key);
		user.getFriendlist().remove(friend.getKey());
		friend.getFriendlist().remove(user.getKey());
		userDAO.closeconnect();
		return SUCCESS;
	}
}
