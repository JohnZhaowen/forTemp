package com.springboot.schedule.springbootschedule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
 
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations( ResourceUtils.CLASSPATH_URL_PREFIX+"/static/img/");
        registry.addResourceHandler("/js/**").addResourceLocations( ResourceUtils.CLASSPATH_URL_PREFIX+"/static/js/");
        registry.addResourceHandler("/css/**").addResourceLocations( ResourceUtils.CLASSPATH_URL_PREFIX+"/static/css/");
        registry.addResourceHandler("/lib/layui/**").addResourceLocations( ResourceUtils.CLASSPATH_URL_PREFIX+"/static/lib/layui/");
        registry.addResourceHandler("/fonts/**").addResourceLocations( ResourceUtils.CLASSPATH_URL_PREFIX+"/static/fonts/");
        registry.addResourceHandler("/**").addResourceLocations( ResourceUtils.CLASSPATH_URL_PREFIX+"/static/**");
    }
}
