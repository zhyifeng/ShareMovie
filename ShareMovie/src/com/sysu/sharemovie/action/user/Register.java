package com.sysu.sharemovie.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sysu.sharemovie.dao.SMUserDAOImpl;
import com.sysu.sharemovie.dao.interfaces.SMUserDAO;
import com.sysu.sharemovie.jdo.SMUser;

@SuppressWarnings("serial")
public class Register extends ActionSupport implements ModelDriven<SMUser>,ServletRequestAware {

	private SMUser user = new SMUser();
	private HttpServletRequest request;
	private String repassword;
	
	public String execute() throws Exception {
		SMUserDAO userDAO = new SMUserDAOImpl();
		if (!repassword.equals(user.getPassword())){
			this.addActionError("password and repassword are not equal");
			return INPUT;
		}
		if (!userDAO.addSMUser(user)) {
			this.addActionError("username has been used");
			return INPUT;
		}
		HttpSession session = request.getSession();
		session.setAttribute("username", user.getUsername());
		session.setMaxInactiveInterval(60);
		this.addActionMessage("Congratulation, Register Successfully");
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	@Override
	public SMUser getModel() {
		return user;
	}
	
	public void setRepassword(String repassword){
		this.repassword = repassword;
	}
}
