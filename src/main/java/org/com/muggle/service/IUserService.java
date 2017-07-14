package org.com.muggle.service;

import org.com.muggle.model.User;

public interface IUserService {
	public User getUserById(int userId);
	
	public void saveUser(User user);
}
