/**
 * Copyright (C), 2015-2018,
 * FileName: GithubProperties
 * Author:   Administrator
 * Date:     2018-10-03 17:06
 * Description: no
 * History:
 * <author>          <time>          <version>          <desc>
 * Wangjun           修改时间           版本号              描述
 */

package com.jun.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@ConfigurationProperties("github")
@Validated
public class GithubProperties {
    /**
     *  Github API token ("user:sampletoken")
     */
    @Pattern(regexp = "\\w+:\\w+")
    private String token;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
