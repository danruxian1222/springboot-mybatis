package com.adu.learn.mybatis.config;

import com.adu.learn.mybatis.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> urls = new ArrayList<>();
//        urls.add("/favicon.ico");
//        urls.add("/error");
//        urls.add("/swagger-resources/**");
//        urls.add("/webjars/**");
////        urls.add("/v2/**");
//        urls.add("/doc.html");
//        urls.add("**/swagger-ui.html");
//        urls.add("/swagger-ui.html/**");
//        urls.add("/");
//        urls.add("/csrf");
        urls.add("/v1/login");

        // 注册Sa-Token的路由拦截器，并排除登录接口或其他可匿名访问的接口地址 (与注解拦截器无关)
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/v1/**")
                .excludePathPatterns(urls);
    }


    // 资源映射增加
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
