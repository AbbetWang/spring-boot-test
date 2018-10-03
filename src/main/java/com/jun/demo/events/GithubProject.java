/**
 * Copyright (C), 2015-2018,
 * FileName: GithubProject
 * Author:   Administrator
 * Date:     2018-10-03 13:27
 * Description: my
 * History:
 * <author>          <time>          <version>          <desc>
 * Wangjun           修改时间           版本号              描述
 */

package com.jun.demo.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class GithubProject implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String orgName;

    @Column(unique = true)
    private String repoName;

    public GithubProject() {

    }

    public GithubProject(String orgName, String repoName) {
        this.orgName = orgName;
        this.repoName = repoName;
    }
    public Long getId(){return id;}
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    @Override
    public String toString() {
        return "GithubProject{" +
                "id=" + id +
                ", orgName='" + orgName + "'" +
                ", repoName='" + repoName + "'";
    }
}
