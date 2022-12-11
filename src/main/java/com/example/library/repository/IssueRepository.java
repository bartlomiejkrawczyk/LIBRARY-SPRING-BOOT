package com.example.library.repository;

import com.example.library.entity.Issue;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Integer> {

	List<Issue> findAllByIsbnAndUserIdIsNull(String isbn);
}
