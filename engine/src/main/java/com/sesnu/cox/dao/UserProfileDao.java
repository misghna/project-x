package com.sesnu.cox.dao;

import java.util.List;

import com.sesnu.cox.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
