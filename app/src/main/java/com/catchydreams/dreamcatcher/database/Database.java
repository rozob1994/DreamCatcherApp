package com.catchydreams.dreamcatcher.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.catchydreams.dreamcatcher.database.user.UserDao;
import com.catchydreams.dreamcatcher.database.user.UserEntity;

@androidx.room.Database(entities = {UserEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {
    private static Database instance;
    public static String UserDb = "Users";

    public static synchronized Database getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), Database.class, UserDb)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract UserDao userDao();
}
