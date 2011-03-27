package com.sysu.sharemovie.dao.interfaces;

import com.sysu.sharemovie.jdo.SMUser;

public interface SMUserDAO {
	
	public boolean addSMUser(SMUser user) throws Exception;
	
	public boolean validateSMUser(SMUser user) throws Exception;
}
