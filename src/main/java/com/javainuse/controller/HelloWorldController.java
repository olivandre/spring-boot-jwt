package com.javainuse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloWorldController {

	@RequestMapping({ "/hello" })
	public String firstPage() {
		log.info("hello world");
		return "Hello World";
	}
	
}