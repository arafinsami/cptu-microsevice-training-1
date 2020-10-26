package com.cptu.proxy;

import org.json.simple.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "apigateway")
public interface UserProxy {

	@PostMapping("/namefinder/user/{name}")
	public ResponseEntity<JSONObject> findByName(@PathVariable("name") String name);
}
