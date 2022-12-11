package com.example.library.controller;

import com.example.library.entity.User;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("user")
@RestController
public class UserController {

	private final UserService userService;

	@PostMapping({"/", ""})
	public User register(@RequestBody User user) {
		return userService.saveUser(user);
	}
}
