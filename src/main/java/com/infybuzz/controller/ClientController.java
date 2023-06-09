package com.infybuzz.controller;

import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.response.StudentResponse;
import org.springframework.web.bind.annotation.*;
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
	public StudentResponse getStudent(@PathVariable Integer id) {
		return clientService.getStudent(id);
	}

	@PostMapping("/create")
	public StudentResponse createStudent(
			@RequestBody CreateStudentRequest createStudentRequest) {
		return clientService.createStudent(createStudentRequest);
	}

}
