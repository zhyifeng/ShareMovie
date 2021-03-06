package com.sysu.sharemovie.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements ServletRequestAware{
	protected HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	protected void setSession(String arg0, Object arg1) {
		HttpSession session = request.getSession();
		session.setAttribute(arg0, arg1);
		session.setMaxInactiveInterval(60*60*3);
	}
	
	protected Object getSession(String arg0) {
		HttpSession session = request.getSession();
		return session.getAttribute(arg0);
	}
	
	protected boolean loggedIn() {
		if (getSession("userkey")==null)
			return false;
		else
			return true;
	}
}
