package com.sysu.sharemovie.dao;

import javax.jdo.PersistenceManager;

public class DAOSupoort {
	
	protected PersistenceManager pm = null;
	
	protected void addtodatabase(Object object) throws Exception{
		pm = PMF.get().getPersistenceManager();
		
	}
	
}
