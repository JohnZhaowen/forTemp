package com.springboot.schedule.springbootschedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * 主要配置多视图实现的视图解析器相关bean实例
 *
 * @author
 *
 */

@Configuration
public class ViewResolverConfiguration {

	@Bean("FreeMarkerConfigurer")
	public FreeMarkerConfigurer get() {
		FreeMarkerConfigurer t = new FreeMarkerConfigurer();
		t.setDefaultEncoding("utf-8");
		t.setTemplateLoaderPaths("classpath:/templates/");
		return t;
	}

}
