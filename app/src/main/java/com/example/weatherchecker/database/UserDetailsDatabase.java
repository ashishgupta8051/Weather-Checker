package com.example.weatherchecker.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.weatherchecker.model.UserDetails;
import com.example.weatherchecker.utils.Credentials;

@Database(entities = UserDetails.class, version = 1, exportSchema = false)
public abstract class UserDetailsDatabase extends RoomDatabase {
    public abstract UserDetailsDao userDetailsDao();

    private static UserDetailsDatabase instance;

    public static UserDetailsDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, UserDetailsDatabase.class, Credentials.DATABSE)
                    .allowMainThreadQueries().build();
        return instance;
    }
}
