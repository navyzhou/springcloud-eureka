package com.yc.springcloud.eureka.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello client2";
	}
	
	@RequestMapping("/info")
	public void intfo(HttpServletResponse response) {
		try {
			response.sendRedirect("/index.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/ss")
	public String getServices() {
		System.out.println("当前eureka中注册的所有服务器如下：");
		List<String> list = discoveryClient.getServices();
		for (String str : list) {
			System.out.println("服务器：" + str);
		}
		return "访问成功";
	}
}
