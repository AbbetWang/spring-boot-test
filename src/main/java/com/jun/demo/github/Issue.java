/**
 * Copyright (C), 2015-2018,
 * FileName: Issue
 * Author:   Administrator
 * Date:     2018-10-03 15:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Wangjun           修改时间           版本号              描述
 */

package com.jun.demo.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Issue {
    private final String htmlUrl;

    private final int number;

    private final String title;

    @JsonCreator
    public Issue(@JsonProperty("html_url") String htmlUrl,
                 @JsonProperty("number") int number, @JsonProperty("title") String title) {
        this.htmlUrl = htmlUrl;
        this.number = number;
        this.title = title;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }
}
