package com.a.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AController {
	@GetMapping("/a")
	@ResponseBody
	public String a() {
		return "a controller입니다";
	}

}
