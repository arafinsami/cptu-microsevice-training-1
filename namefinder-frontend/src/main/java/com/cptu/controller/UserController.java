package com.cptu.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cptu.dto.UserDto;
import com.cptu.proxy.UserProxy;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

	private final UserProxy userProxy;

	@PostMapping("/{name}")
	public ResponseEntity<JSONObject> findByName(@PathVariable("name") String name) {

		ResponseEntity<JSONObject> response = userProxy.findByName(name);
		return response;
	}

	@PostMapping("/spring-rest-template/{name}")
	public ResponseEntity<UserDto> findByNameRestTemplate(@PathVariable("name") String name) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("name", name);

		ResponseEntity<UserDto> responseEntity = new RestTemplate()
				.postForEntity("http://localhost:8888/namefinder/user/" + name, uriVariables, UserDto.class);

		UserDto dto = responseEntity.getBody();

		return new ResponseEntity<UserDto>(dto, HttpStatus.OK);
	}
}
