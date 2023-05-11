package com.infybuzz.controller;

import src.main.java.com.infybuzz.response.StudentResponse;
import com.infybuzz.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class ClientController {
	
	@Autowired
	ClientService clientService;

	@GetMapping("/get/{id}")
	public StudentResponse getStudent(@PathVariable Integer id) throws Exception {
		return clientService.getStudent(id);
	}
	
}
