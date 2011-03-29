package com.sysu.sharemovie.action.user;

import com.opensymphony.xwork2.ModelDriven;
import com.sysu.sharemovie.action.BaseAction;
import com.sysu.sharemovie.dao.SMUserDAO;
import com.sysu.sharemovie.jdo.SMUser;

@SuppressWarnings("serial")
public class Register extends BaseAction implements ModelDriven<SMUser> {

	private SMUser user = new SMUser();
	private String repassword;
	
	public String execute(){
		SMUserDAO userDAO = new SMUserDAO();
		userDAO.makeconnect();
		if (!repassword.equals(user.getPassword())){
			this.addActionError("password and repassword are not equal");
			return INPUT;
		}
		if (!userDAO.addSMUser(user)) {
			this.addActionError("username has been used");
			return INPUT;
		}
		setSession("username", user.getUsername());
		setSession("userkey", user.getKey());
		userDAO.closeconnect();
		this.addActionMessage("Congratulation, Register Successfully");
		return SUCCESS;
	}

	@Override
	public SMUser getModel() {
		return user;
	}
	
	public void setRepassword(String repassword){
		this.repassword = repassword;
	}
}
