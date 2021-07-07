package com.online.taxi.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 启动FeignClient扫描，并配置：
 * 1. 并指定包包扫描地址
 * 2. 设置交互为JAX-RS2方式，实际Feign中的JAX-RS2指的是1.1
 * 3. 在请求时自动加入基于OAuth2的客户端模式认证的Header
 *
 **/
@Configuration
@Profile("!test")
@EnableFeignClients(basePackages = {"com.online.taxi"})
public class FeignConfiguration implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        requestTemplate.header("Authorization", request.getHeader("Authorization"));
    }
}
