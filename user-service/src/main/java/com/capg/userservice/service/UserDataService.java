package com.capg.userservice.service;

import java.util.List;
import java.util.Optional;

import com.capg.userservice.entity.UsersData;

public interface UserDataService {

    public List<UsersData> getAllUsers();

    public Optional<UsersData> getUserById(int id);

    public UsersData saveUserData(UsersData userData);

    UsersData updateUserData(UsersData userData, int userId);

    UsersData updateUserData(UsersData userData, String email);

   public Optional<UsersData> getUserDataByEmail(String email);

    public String deleteUserData(int userId);


}
