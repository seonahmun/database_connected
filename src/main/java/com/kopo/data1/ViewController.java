package com.kopo.data1;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	//메인페이지로 이동
	@GetMapping("/")
	public String root() {

		return "main";
	}
	
	
	//회원페이지로 이동
	@GetMapping("/myPage")
	public String loginCheck() {
			
		
		return "myPage";
	}
	

	//회원가입페이지로 이동
	@GetMapping("/userJoinPage")
	public String userJoinPage() {

		return "join";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}

	
	


	
}
