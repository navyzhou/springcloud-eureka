package com.yc.springcloud.eureka.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/info")
	public String home() {
		return "hello client1 from port " + port;
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello client1";
	}
	
	@RequestMapping("/rd")
	public int rd() {
		Random rd = new Random();
		return rd.nextInt();
	}
}
