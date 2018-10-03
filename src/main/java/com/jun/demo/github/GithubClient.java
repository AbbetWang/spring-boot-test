/**
 * Copyright (C), 2015-2018,
 * FileName: GithubClient
 * Author:   Administrator
 * Date:     2018-10-03 15:33
 * Description: no
 * History:
 * <author>          <time>          <version>          <desc>
 * Wangjun           修改时间           版本号              描述
 */

package com.jun.demo.github;
import com.jun.demo.GithubProperties;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class GithubClient {
    private  static final String EVENT_ISSUES_URL = "https://api.github.com/repos/{owner}/{repo}/issues/events";
    private final RestTemplate restTemplate;

    public GithubClient(RestTemplateBuilder builder, GithubProperties properties) {
        this.restTemplate = builder
                .additionalInterceptors(new GithubAppTokenIntercepter(properties.getToken()))
                .build();
    }
    public ResponseEntity<RepositoryEvent[]> fetchEvents(String orgName, String repoName) {
        return this.restTemplate.getForEntity(EVENT_ISSUES_URL, RepositoryEvent[].class, orgName, repoName);
    }
    private static class GithubAppTokenIntercepter implements ClientHttpRequestInterceptor{

        private final String token;

         GithubAppTokenIntercepter(String token) {
            this.token = token;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
                                            ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
            if (StringUtils.hasText(this.token)){
                byte[] basicAuthValue = this.token.getBytes(StandardCharsets.UTF_8);
                httpRequest.getHeaders().set(HttpHeaders.AUTHORIZATION,"Basic "+ Base64Utils.encodeToString(basicAuthValue));
            }
            return clientHttpRequestExecution.execute(httpRequest,bytes);
        }
    }
}
