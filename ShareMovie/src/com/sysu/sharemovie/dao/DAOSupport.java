package com.sysu.sharemovie.dao;

import javax.jdo.PersistenceManager;

public class DAOSupport {
	
	protected PersistenceManager pm = null;
	
	public void makeconnect() {
		pm = PMF.get().getPersistenceManager();
	}
	
	public void closeconnect() {
		pm.close();
	}
	
}
