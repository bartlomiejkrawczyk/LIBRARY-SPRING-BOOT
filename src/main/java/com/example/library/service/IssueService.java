package com.example.library.service;

import com.example.library.entity.Issue;
import java.util.Optional;

public interface IssueService {

	Optional<Issue> borrowIssue(String isbn, Integer userId);

	Optional<Issue> returnIssue(Integer issueId, Integer userId);

	Issue addIssue(String isbn);
}
