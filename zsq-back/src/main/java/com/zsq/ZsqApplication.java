package com.zsq;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ZsqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZsqApplication.class, args);
		System.out.println("正在运行...");
	}

	@Configuration
	public static class WebConfig implements WebMvcConfigurer {
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			// 添加外部文件夹映射
			registry.addResourceHandler("/upload/**")  // 访问路径
				   .addResourceLocations("file:" + System.getProperty("user.dir") + "/upload/");  // 文件实际路径
		}
	}

}
