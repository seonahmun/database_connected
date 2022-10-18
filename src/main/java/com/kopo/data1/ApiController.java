package com.kopo.data1;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@GetMapping("/create_table")
	public HashMap<String, String> createTable() {

		HashMap<String, String> result = new HashMap<String, String>();

		DB db = new DB();
		boolean isSuccess = db.createTable();

		if (isSuccess) {
			result.put("message", "success created");
		} else {
			result.put("message", "fail");
		}

		return result;
	}
	
	@GetMapping("/select_loginCheck")
	public boolean selectLoginCheck(@RequestParam String id, String password, HttpServletRequest request){
		
		DB db = new DB();
		
		boolean isLoginCheck = db.selectLoginCheck(id, password);
		
		boolean result = false;
		
		System.out.println(isLoginCheck);
		
		if(isLoginCheck == true) {
			User user = new User();
			user.setId(id);
			user.setPassword(password);
			
			//id 세션저장
			request.getSession().setAttribute("id", id);
			
			result = true;
		}else if(isLoginCheck == false) {
			
			result = false;
		}

		return result;
	}

	

}
