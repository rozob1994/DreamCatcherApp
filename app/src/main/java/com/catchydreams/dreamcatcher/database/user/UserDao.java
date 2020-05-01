package com.catchydreams.dreamcatcher.database.user;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {
    @Insert
    void insertUser(UserEntity user);

    @Query("Select * from user where email = :username")
    UserEntity retrieveUserByUsername(String username);

    @Query("Select * from user where uid = :uid")
    UserEntity retrieveUserByUid(int uid);

    @Update
    void updateUser(UserEntity userEntity);

    @Delete
    void deleteUser(UserEntity userEntity);

}
