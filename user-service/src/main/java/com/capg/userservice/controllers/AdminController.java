package com.capg.userservice.controllers;

import com.capg.userservice.service.UserDataService;
import com.capg.userservice.entity.UsersData;
import com.capg.userservice.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/allusers")
    public ResponseEntity<List<UsersData>> getAllUsers() throws ResourceNotFoundException {
        List<UsersData> list = userDataService.getAllUsers();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("There are no users present in the database!");
        }
        return ResponseEntity.ok(list);
    }
    
    @PutMapping("/user/update/{id}")
    public ResponseEntity<UsersData> updateUserData(@RequestBody UsersData userData ,
                                                         @PathVariable("id") int userId){
        UsersData updatedUserData = userDataService.updateUserData(userData,userId);
        return  ResponseEntity.ok(updatedUserData);
    }
    
    @DeleteMapping("/user/delete/{id}")
    public void deleteUserData(@PathVariable("id") int userId) throws ResourceNotFoundException
    {
        Optional<UsersData> userData = userDataService.getUserById(userId);
        if(userData.isEmpty()) {
            throw new ResourceNotFoundException("No User found with id " + userId);
        }
        userDataService.deleteUserData(userId);
    }

   
   
}
