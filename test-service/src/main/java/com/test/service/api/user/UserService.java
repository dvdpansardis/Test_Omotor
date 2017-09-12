package com.test.service.api.user;

import java.util.List;

import com.test.model.api.user.User;

public interface UserService {
	
	User findUser(final long id);
	
	List<User> findAllUsers();
	
	void saveUser(final User user);
	
	void deleteUser(final long id);
	
	void updateUser(long id, final User user);

}
