package com.example.weatherchecker.repository;

import com.example.weatherchecker.database.UserDetailsDao;
import com.example.weatherchecker.model.UserDetails;

public class UserDetailsRepository {
    private UserDetailsDao userDetailsDao;

    public UserDetailsRepository(UserDetailsDao userDetailsDao) {
        this.userDetailsDao = userDetailsDao;
    }

    public void addUserDetails(UserDetails userDetails){
        userDetailsDao.addDetails(userDetails);
    }

    public UserDetails getSingleUserDetails(long id){
        return userDetailsDao.getSingleUserDetails(id);
    }

}
