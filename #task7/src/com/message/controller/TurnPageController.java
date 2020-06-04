package com.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/user")
public class TurnPageController {
	/*
	 * 打开其他页面
	 */
	@RequestMapping("/{page}")
	public  String showPage(@PathVariable String page){
		return page;
	}
}
