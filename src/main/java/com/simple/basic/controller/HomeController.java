package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "hello";
	}
	
	@GetMapping("/abc")
	@ResponseBody
	public String res() {
		return "<h3>abc</h3>";
	}
}
