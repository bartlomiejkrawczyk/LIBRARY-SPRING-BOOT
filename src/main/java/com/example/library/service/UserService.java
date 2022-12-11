package com.example.library.service;

import com.example.library.entity.User;
import java.util.Optional;

public interface UserService {

	Optional<User> findUserByLogin(String login);

	User saveUser(User user);
}
