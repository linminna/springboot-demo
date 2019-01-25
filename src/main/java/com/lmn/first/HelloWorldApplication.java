package com.lmn.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloWorldApplication extends SpringBootServletInitializer{

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldApplication.class);

	@RequestMapping("/home.tm")
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("/hello.htm")
	String hello() {
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		logger.info("开始加载。。。");
		SpringApplication application = new SpringApplication(HelloWorldApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
		logger.info("加载结束。。。");
	}
	
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HelloWorldApplication.class);
	}*/
}
