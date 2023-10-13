package com.codingbox.springprj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
	/*
	 *  /hello 요청, return hello.html
	 */
	@GetMapping("hello")
	public  String hello(Model model) {
		model.addAttribute("data", "hello");
		return "hello";
	}
}
