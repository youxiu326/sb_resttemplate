package com.huarui.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

public class HeadCtrl {


    @Autowired
    private RestTemplate restTemplate;

    /**
     * 测试传递请求头数据
     * @param request
     * @param response
     * @param url
     * @return
     */
    private String request(HttpServletRequest request, HttpServletResponse response,String url) {

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            headers.add(key, value);
        }
        String restStrResult = restTemplate.postForObject(
                url,
                /*携带header*/new HttpEntity<>(headers), String.class,
                /*携带parameter*/request.getParameterMap());
        return restStrResult;
    }
} 