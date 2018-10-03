/**
 * Copyright (C), 2015-2018,
 * FileName: EventsController
 * Author:   Administrator
 * Date:     2018-10-03 15:42
 * Description: no
 * History:
 * <author>          <time>          <version>          <desc>
 * Wangjun           修改时间           版本号              描述
 */

package com.jun.demo.events;

import com.jun.demo.github.GithubClient;
import com.jun.demo.github.RepositoryEvent;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventsController {
    private final GithubClient githubClient;
    private final GithubProjectRepository repository;

    public EventsController(GithubClient githubClient, GithubProjectRepository repository) {
        this.githubClient = githubClient;
        this.repository = repository;

    }
    @GetMapping("/events/{projectName}")
    @ResponseBody
    public RepositoryEvent[] fetchEvents(@PathVariable String projectName){
        GithubProject project = this.repository.findByRepoName(projectName);
        RepositoryEvent[] fe =this.githubClient.fetchEvents(project.getOrgName(),project.getRepoName()).getBody();
        return fe;
    }
}
