package com.test.service.api.user;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.api.user.User;
import com.test.repository.user.UserRepository;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUser(long id) {
		User user = userRepository.findOne(id);
		return user == null ? new User() : user;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return Collections.unmodifiableList(allUsers);
	}

	@Override
	public void saveUser(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.delete(id);
	}

	@Override
	public void updateUser(long id, User user) {
		User foundUser = this.findUser(id);
		
		foundUser.setName(user.getName());
		foundUser.setTelephoneNumber(user.getTelephoneNumber());
		foundUser.setEmail(user.getEmail());
		foundUser.setGender(user.getGender());
		
		userRepository.saveAndFlush(foundUser);
	}

}
