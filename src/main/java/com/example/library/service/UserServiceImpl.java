package com.example.library.service;

import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
