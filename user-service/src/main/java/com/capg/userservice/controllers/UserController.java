package com.capg.userservice.controllers;

import com.capg.userservice.entity.UsersData;
import com.capg.userservice.exception.ResourceNotFoundException;
import com.capg.userservice.service.UserDataService;
import com.capg.userservice.service.impl.SequenceGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserDataService userDataService;

	@PostMapping("/save")
	public ResponseEntity<UsersData> saveUserData(@RequestBody UsersData userData) {
		userData.setId((sequenceGeneratorService.getSequenceNumber(UsersData.SEQUENCE_NAME)));
		UsersData savedUserData = userDataService.saveUserData(userData);
		return ResponseEntity.ok(savedUserData);
	}

	@PutMapping("/update/username/{email}")
	public ResponseEntity<UsersData> updateUserData(@RequestBody UsersData userData,
			@PathVariable("email") String email) {
		UsersData updatedUserData = userDataService.updateUserData(userData, email);
		return ResponseEntity.ok(updatedUserData);
	}

	@GetMapping("/username/{email}")
	public ResponseEntity<UsersData> getUserDataByEmail(@PathVariable("email") String email)
			throws ResourceNotFoundException {

		Optional<UsersData> userData = userDataService.getUserDataByEmail(email);
		if (userData.isEmpty()) {
			throw new ResourceNotFoundException("No User found with email: " + email);
		}
		return ResponseEntity.ok(userData.get());

	}

}
