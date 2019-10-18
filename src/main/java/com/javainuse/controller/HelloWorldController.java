package com.javainuse.controller;

import com.javainuse.config.JwtRequestFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private static Logger logger = LogManager.getLogger(JwtRequestFilter.class);
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		logger.info("hello world");
		return "Hello World";
	}
	
}