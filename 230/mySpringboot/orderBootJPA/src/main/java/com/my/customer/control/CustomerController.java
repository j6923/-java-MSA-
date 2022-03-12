package com.my.customer.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.customer.service.CustomerService;
import com.my.customer.vo.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@PostMapping("login")
	@ResponseBody
	public Map<String, Object> login(String id, String pwd, HttpSession session) {
		session.removeAttribute("loginInfo"); //초기화
		String resultMsg = "";
		int status = 0;
		try {
			Customer c = service.login(id, pwd);
			session.setAttribute("loginInfo", c);
			//3.응답결과만들기
			resultMsg = "로그인 성공"; 
			status = 1;
		}catch(FindException e) {
			e.printStackTrace();
			resultMsg = "로그인 실패";
		}
		//return resultMsg;
//		return "{\"status\":" + status + ", \"msg\":\"" + resultMsg + "\"}";
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("status", status);
		returnMap.put("msg", resultMsg);
		return returnMap;
	}
	
	
	//@PostMapping("login")
//	@RequestMapping("login")
//	@ResponseBody
//	public String login(String id, String pwd, HttpSession session) {
//		session.removeAttribute("loginInfo"); //초기화
//		String resultMsg = "";
//		int status = 0;
//		try {
//			Customer c = service.login(id, pwd);
//			session.setAttribute("loginInfo", c);
//			//3.응답결과만들기
//			resultMsg = "login success";//"로그인 성공"; 
//			status = 1;
//		}catch(FindException e) {
//			resultMsg = "login fail"; //"로그인 실패";
//		}
//		//return resultMsg;
//		return "{\"status\":" + status + ", \"msg\":\"" + resultMsg + "\"}";
//		
//	}
	
//	@PostMapping("login")
//	public String login(String id, String pwd, HttpSession session, Model model) {
//		session.removeAttribute("loginInfo"); //초기화
//		String resultMsg = "";
//		String viewName = "jsonresult.jsp";
//		
//		try {
//			Customer c = service.login(id, pwd);
//			session.setAttribute("loginInfo", c);
//
//			//3.응답결과만들기
//			resultMsg = "로그인 성공";
//			model.addAttribute("status", 1);
//		}catch(FindException e) {
//			resultMsg = "로그인 실패";
//			model.addAttribute("status", 0);
//		}
//		model.addAttribute("msg", resultMsg);
//		return viewName;
//	}
	
	@RequestMapping("logout")
	public ResponseEntity logout(HttpSession session) {
		session.removeAttribute("loginInfo");
//		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("iddupchk")
	@ResponseBody
	public Map<String, Object> idDupChk(String id) {
		String resultMsg = "";	
		int status = 0;
		try {
			service.iddupchk(id);
			//3. 응답결과 계산
			resultMsg = "이미 사용중인 아이디입니다";
//			status =0;
		} catch (FindException e) {
			//3. 응답결과 계산
			resultMsg = "사용가능한 아이디입니다";
			status = 1;
		}
		//4. 응답결과를 요청속성으로 설정
//		model.addAttribute("msg", resultMsg);
//		return viewName;
		Map<String,Object>returnMap = new HashMap<>();
		returnMap.put("msg", resultMsg);
		returnMap.put("status", status);
		return returnMap;
	}
//	public String idDupChk(String id, Model model) {
//		String viewName = "jsonresult.jsp";
//		String resultMsg = "";		
//		try {
//			service.iddupchk(id);
//			//3. 응답결과 계산
//			resultMsg = "이미 사용중인 아이디입니다";
//			model.addAttribute("status", 0);
//		} catch (FindException e) {
//			//3. 응답결과 계산
//			resultMsg = "사용가능한 아이디입니다";
//			model.addAttribute("status", 1);
//		}
//		//4. 응답결과를 요청속성으로 설정
//		model.addAttribute("msg", resultMsg);
//		return viewName;
//	}
	
	@PostMapping("signup")
	@ResponseBody
	public Map<String,Object> signup(Customer c) {
		logger.warn("c.address=" + c.getAddress());
		String resultMsg = "";
		int status = 0;
		try {
			service.signup(c);
			status = 1;
			resultMsg = "가입성공";
		} catch (AddException e) {
			e.printStackTrace();			
			resultMsg = e.getMessage();
		}
//		model.addAttribute("msg", resultMsg);
//		return viewName;
		Map<String,Object> returnMap = new HashMap<>();
		returnMap.put("msg", resultMsg);
		returnMap.put("status", status);
		return returnMap;
	}
	
//	@PostMapping("signup")
//	public String signup(Customer c, Model model) {
//		logger.warn("c.address=" + c.getAddress());
//		String viewName = "jsonresult.jsp";
//		String resultMsg = "";
//		try {
//			service.signup(c);
//			model.addAttribute("status", 1);
//			resultMsg = "가입성공";
//		} catch (AddException e) {
//			e.printStackTrace();
//			model.addAttribute("status", 0);
//			resultMsg = e.getMessage();
//		}
//		model.addAttribute("msg", resultMsg);
//		return viewName;
//	}
}
