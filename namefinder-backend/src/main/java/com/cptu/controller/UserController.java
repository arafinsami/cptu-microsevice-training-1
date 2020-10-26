package com.cptu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cptu.entity.User;
import com.cptu.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/{name}")
	public ResponseEntity<User> findByName(@PathVariable("name") String name) {

		User user = userService.findByName(name).orElseThrow(null);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
