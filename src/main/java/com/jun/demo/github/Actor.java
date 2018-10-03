/**
 * Copyright (C), 2015-2018,
 * FileName: Actor
 * Author:   Administrator
 * Date:     2018-10-03 15:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Wangjun           修改时间           版本号              描述
 */

package com.jun.demo.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Actor {
    private final String login;
    private final String avatarUrl;
    private final String htmlUrl;
    @JsonCreator
    public Actor(@JsonProperty("login") String login,
                 @JsonProperty("avatar_url") String avatarUrl,@JsonProperty("html-url") String htmlUrl){
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }
}
