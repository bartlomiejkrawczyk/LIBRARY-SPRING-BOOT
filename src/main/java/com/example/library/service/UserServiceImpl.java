package com.example.library.service;

import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public Optional<User> findUserByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
