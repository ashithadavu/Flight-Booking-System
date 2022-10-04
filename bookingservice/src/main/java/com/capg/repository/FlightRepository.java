package com.capg.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.capg.entity.FlightInfo;
//mongo repository is a built in class
//inheritance concept:extends
public interface FlightRepository extends MongoRepository<FlightInfo,String>{


}
