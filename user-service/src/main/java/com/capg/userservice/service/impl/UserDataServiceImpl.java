package com.capg.userservice.service.impl;

import com.capg.userservice.entity.UsersData;
//import com.cg.UserService.Models.DrugsData;
import com.capg.userservice.repository.UserRepository;
import com.capg.userservice.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UsersData> getAllUsers() {
        return  userRepository.findAll();
    }

    @Override
    public Optional<UsersData> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public UsersData saveUserData(UsersData userData) {
        return  userRepository.save(userData);
    }

    @Override
    public Optional<UsersData> getUserDataByEmail(String email) {
        return userRepository.getUserDataByEmail(email);
    }


    @Override
    public UsersData updateUserData(UsersData userData, String email) {
        UsersData dgDB
                = userRepository.getUserDataByEmail(email)
                .get();

        //name update
        if (Objects.nonNull(userData.getName())
                && !"".equalsIgnoreCase(
                userData.getName())) {
            dgDB.setName(
                    userData.getName());
        }
        //update Phone No.
        if (Objects.nonNull(userData.getPhNo())
                && !"".equalsIgnoreCase(
                String.valueOf(userData.getPhNo()))) {
            dgDB.setPhNo(
                    userData.getPhNo()
            );
        }
      
        return  userRepository.save(dgDB);
    }

    @Override
    public UsersData updateUserData(UsersData userData, int userId) {
        UsersData dgDB
                = userRepository.findById(userId)
                .get();

        //name update
        if (Objects.nonNull(userData.getName())
                && !"".equalsIgnoreCase(
                userData.getName())) {
            dgDB.setName(
                    userData.getName());
        }
        //update Phone No.
        if(Objects.nonNull(userData.getPhNo())
                && !"".equalsIgnoreCase(
                String.valueOf(userData.getPhNo()))) {
            dgDB.setPhNo(
                    userData.getPhNo()
            );
        }
       
        
        return  userRepository.save(dgDB);
    }

    @Override
    public String deleteUserData(int userId) {

        userRepository.deleteById(userId);
        return "Successfully Deleted";
    }
}
