package com.evan.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	public static String SUCCESS = "success";

	@RequestMapping("helloworld")
	public String hello() {
		System.out.println("helloworld");
		return SUCCESS;
	}
}
