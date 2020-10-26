package com.cptu.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cptu.entity.User;
import com.cptu.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public Optional<User> findByName(String name) {
		return userRepository.findByName(name);
	}
}
