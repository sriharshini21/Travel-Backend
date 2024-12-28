package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Hotels;
import com.example.demo.model.Train;
import com.example.demo.model.User;
import com.example.demo.repo.BusRepo;
import com.example.demo.repo.HotelRepo;
import com.example.demo.repo.TrainRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.model.Bus;

@Service
public class UserService {

	@Autowired 
	private UserRepo userRepo;
	
	@Autowired
	private HotelRepo hotelRepo;
	
	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private TrainRepo trainRepo;
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public List<Hotels> getHotels(){
		return hotelRepo.findAll();
	}
	
	public List<Bus> getBus(){
		return busRepo.findAll();
	}
	
	public List<Train> getTrain(){
		return trainRepo.findAll();
	}
}
