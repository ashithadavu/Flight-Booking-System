package com.capg.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.userservice.entity.UsersData;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UsersData,Integer> {

	@Query("{email:'?0'}")
   Optional<UsersData> getUserDataByEmail(String email);


}
