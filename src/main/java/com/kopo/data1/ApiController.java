package com.kopo.data1;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
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

}
