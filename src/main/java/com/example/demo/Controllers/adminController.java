package com.example.demo.Controllers;

import com.example.demo.Database.Database;
import com.example.demo.inputClasses.adminInput;
import com.example.demo.systemUsers.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")

public class adminController {

	@Autowired
	Database data;

	Admin admin = new Admin("Ahmed", "1231451",  "Ahmed@gmail.com",  "123456");
	
	@PostMapping("/verifyDriver")
	public String verifyDriver(@RequestBody adminInput input) {

		return admin.verifydriverRegistration(input.username);
	}

	@PostMapping("/suspend")
	public String suspend(@RequestBody adminInput input) {
		return admin.suspend(input.username);
	}

	@PostMapping("/unsuspend")
	public String unsuspend(@RequestBody adminInput input) {

		return admin.unsuspend(input.username);
	}


}