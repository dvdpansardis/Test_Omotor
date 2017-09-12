package com.test.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.api.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
