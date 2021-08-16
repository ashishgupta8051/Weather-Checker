package com.example.weatherchecker.database;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.weatherchecker.model.UserDetails;

@androidx.room.Dao
public interface UserDetailsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addDetails(UserDetails userDetails);

    @Query("select * from user_details_table WHERE phoneNumber = :id")
    UserDetails getSingleUserDetails(long id);

}
