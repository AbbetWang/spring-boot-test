package com.jun.demo.events;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GithubProjectRepository extends CrudRepository<GithubProject,Long> {
    GithubProject findByRepoName(String repoName);
}
