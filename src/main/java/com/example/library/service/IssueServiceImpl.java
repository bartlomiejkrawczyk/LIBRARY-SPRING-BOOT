package com.example.library.service;

import com.example.library.entity.Issue;
import com.example.library.repository.IssueRepository;
import jakarta.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class IssueServiceImpl implements IssueService {

	private final IssueRepository issueRepository;

	@Override
	@Transactional
	public Optional<Issue> borrowIssue(String isbn, Integer userId) {
		return issueRepository.findAllByIsbnAndUserIdIsNull(isbn)
				.stream()
				.findAny()
				.map(issue -> {
					issue.setUserId(userId);
					issue.setBookBorrowDate(new Timestamp(System.currentTimeMillis()));
					return issue;
				})
				.map(issueRepository::save);
	}

	@Override
	public Optional<Issue> returnIssue(String isbn, Integer userId) {
		return issueRepository.findAllByIsbnAndUserIdIsNull(isbn)
				.stream()
				.findAny()
				.filter(issue -> Objects.equals(issue.getUserId(), userId))
				.map(issue -> {
					issue.setUserId(null);
					issue.setBookBorrowDate(null);
					return issue;
				})
				.map(issueRepository::save);
	}

	@Override
	public Issue addIssue(String isbn) {
		return issueRepository.save(
				Issue.builder().isbn(isbn).build()
		);
	}
}
