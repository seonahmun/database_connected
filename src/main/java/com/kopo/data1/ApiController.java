package com.kopo.data1;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public boolean selectLoginCheck(@RequestParam String id, String password, 
			HttpServletRequest request, User user){
				
		DB db = new DB();
		
		//id, password 확인
		System.out.println("id: " + id);
		System.out.println("password: " + password);
		
		//id, password true/false 확인
		boolean isLoginCheck = db.selectLoginCheck(id, password);
		
		System.out.println(isLoginCheck);
		
		//결과값 default false 저장
		boolean result = false;
		if(isLoginCheck == true) {					
			
			//user에 저장
			user.setId(id);
			
			//id 세션 저장
			request.getSession().setAttribute("id", id);
			
			//id로 사용자 type, name 찾기
			ArrayList<User> userList = db.selectUserInfo(id);
			
			//arrayList 확인
			for(int i=0; i<userList.size(); i++) {
				//System.out.println("type: " + userList.get(i).getType());
				//System.out.println("name: " + userList.get(i).getName());
				
				//user 저장
				user.setType(userList.get(i).getType());
				user.setName(userList.get(i).getName());
			}
			
			//user에 저장되었는지 확인
			System.out.println("type: " + user.getType());
			System.out.println("name: " + user.getName());
			
			//타입별로 타입이름 지정
			if(user.getType().equals("admin")) {
				user.setTypeName("관리자");
			}else if(user.getType().equals("user")) {
				user.setTypeName("일반사용자");
			}
			
			//타입이름 확인
			System.out.println("typeName: " + user.getTypeName());
			
			//사용자 name, TypeName 세션 저장
			request.getSession().setAttribute("name", user.getName());
			request.getSession().setAttribute("typeName", user.getTypeName());
			
			//db login id, password 맞는 경우 결과값 true return	
			result = true;
		}else if(isLoginCheck == false) {
			//db login id, password 맞지 않을 경우 결과값 false return
			result = false;
		}

		return result;
	}
	
	

	

}
