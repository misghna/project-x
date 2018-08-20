package com.sesnu.cox.service;

import java.util.List;

import com.sesnu.cox.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
