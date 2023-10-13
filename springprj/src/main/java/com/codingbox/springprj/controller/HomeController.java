package com.codingbox.springprj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // < logger를 대신 만들어주는 어노테이션
public class HomeController {
	// log 기록을 남기는 명령문
	// Logger log = LoggerFactory.getLogger(getClass());
	// home화면
	// "/" -> home.html
	@RequestMapping("/")
	public String home(){
		log.info("home Controller");
		return "home";
	}
}
