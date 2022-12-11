package com.example.library.controller;

import com.example.library.entity.Issue;
import com.example.library.entity.User;
import com.example.library.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("borrow")
@RestController
public class IssueController {

	private final IssueService issueService;

	@PutMapping("{isbn}")
	public Issue borrowIssue(@PathVariable String isbn, Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		return issueService.borrowIssue(isbn, user.getId()).orElse(null);
	}

	@PutMapping("return/{issueId}")
	public Issue returnIssue(@PathVariable Integer issueId, Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		return issueService.returnIssue(issueId, user.getId()).orElse(null);
	}

	@PostMapping("{isbn}")
	public Issue addIssue(@PathVariable String isbn) {
		return issueService.addIssue(isbn);
	}
}
