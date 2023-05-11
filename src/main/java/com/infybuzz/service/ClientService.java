package com.infybuzz.service;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.infybuzz.response.StudentResponse;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientService {

	@Autowired
	GraphQLWebClient graphQLWebClient;

	public StudentResponse getStudent(Integer id) throws Exception {
		Map<String, Object> variables = new HashMap<>();
		variables.put("id", id);

		String queryStr = "query student ($id : Int){\r\n" +
				"    student(id : $id){\r\n" +
				"        id\r\n" +
				"        firstName\r\n" +
				"        lastName\r\n" +
				"        email\r\n" +
				"        street\r\n" +
				"        city\r\n" +
				"        learningSubjects(subjectNameFilter : ALL) {\r\n" +
				"            id\r\n" +
				"            subjectName\r\n" +
				"            marksObtained\r\n" +
				"        }\r\n" +
				"        fullName\r\n" +
				"    }\r\n" +
				"}";

		GraphQLRequest request =
				GraphQLRequest.builder()
						.query(queryStr)
						.variables(variables)
						.build();

		try {

			GraphQLResponse graphQLResponse =
					graphQLWebClient
							.post(request)
							.block();

			return graphQLResponse.get("student", StudentResponse.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
