package com.catchydreams.dreamcatcher.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.catchydreams.dreamcatcher.database.posts.PostDao;
import com.catchydreams.dreamcatcher.database.posts.PostsEntity;
import com.catchydreams.dreamcatcher.database.user.UserDao;
import com.catchydreams.dreamcatcher.database.user.UserEntity;

@androidx.room.Database(entities = {UserEntity.class, PostsEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {
    private static Database instance;
    public static String Db = "DreamCatcher";
    public static synchronized Database getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), Database.class, Db)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract UserDao userDao();

    public abstract PostDao postDao();
}
