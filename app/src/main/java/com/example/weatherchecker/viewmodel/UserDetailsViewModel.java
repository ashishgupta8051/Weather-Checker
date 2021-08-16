package com.example.weatherchecker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.weatherchecker.database.UserDetailsDao;
import com.example.weatherchecker.database.UserDetailsDatabase;
import com.example.weatherchecker.model.UserDetails;
import com.example.weatherchecker.repository.UserDetailsRepository;

import io.reactivex.Completable;

public class UserDetailsViewModel extends AndroidViewModel {

    private UserDetailsDao dao;
    private UserDetailsRepository userDetailsRepository;

    public UserDetailsViewModel(@NonNull Application application) {
        super(application);
        dao = UserDetailsDatabase.getInstance(application).userDetailsDao();
        userDetailsRepository = new UserDetailsRepository(dao);
    }

    public void addUserDetails(UserDetails userDetails){
        userDetailsRepository.addUserDetails(userDetails);
    }

    public UserDetails getSingleUserDetails(long id){
        return userDetailsRepository.getSingleUserDetails(id);
    }
}
