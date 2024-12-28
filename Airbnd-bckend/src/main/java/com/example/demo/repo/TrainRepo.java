package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Train;
@Repository
public interface TrainRepo extends JpaRepository<Train, Integer> {

}
