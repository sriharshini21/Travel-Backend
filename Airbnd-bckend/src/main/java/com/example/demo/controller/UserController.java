package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bus;
import com.example.demo.model.Hotels;
import com.example.demo.model.Train;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtFilter;
import com.example.demo.util.JwtUtil;


@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private JwtFilter jwtFilter;

	
	@PostMapping("/login")
	
	public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,String> loginData){
		String username =loginData.get("username");
		String password = loginData.get("password");
		Optional<User> user = userRepo.findByUsername(username);
		if(user.isPresent() && user.get().getPassword().equals(password)) {
			Map<String, String> response = new HashMap<>();
			String token = jwtUtil.generateToken(username);
			response.put("login", "success");
			response.put("token", token);
			response.put("role", user.get().getRole());   
	
			 return ResponseEntity.ok(response);
		}else {
			Map<String, String> response1 = new HashMap<>();
			response1.put("login", "fail");
			 return ResponseEntity.ok(response1);
		
	}}
		
	@GetMapping("/user/hotels")
	public List<Hotels> getHotels(){
		return userService.getHotels();
	}
	
	@GetMapping("/user/buses")
	public List<Bus> getBuses(){
		return userService.getBus();
	}
	
	@GetMapping("/user/trains")
	public List<Train> getTrains(){
		return userService.getTrain();
	}
	
	public JwtFilter getJwtFilter() {
		return jwtFilter;	
	}

	public void setJwtFilter(JwtFilter jwtFilter) {
		this.jwtFilter = jwtFilter;
	}

	public JwtUtil getJwtUtil() {
		return jwtUtil;
	}

	public void setJwtUtil(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

}