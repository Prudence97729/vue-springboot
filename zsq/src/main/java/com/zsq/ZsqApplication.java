package com.zsq;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZsqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZsqApplication.class, args);
		System.out.println("正在运行...");
	}

}
