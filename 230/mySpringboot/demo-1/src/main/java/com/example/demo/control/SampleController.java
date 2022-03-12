package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
	@GetMapping("/greeting")
	@ResponseBody
	public String greeting() {
		return "welcome";
		
	}
	
	@GetMapping("/footer")
	public String footer() {
		return "footer"; //view reserver의 도움을 받아서 
	}
	
}
