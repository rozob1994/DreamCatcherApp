package com.catchydreams.dreamcatcher.database.user;

import androidx.lifecycle.LiveData;
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
    LiveData<UserEntity> retrieveUserByUsername(String username);

    @Query("Select * from user where uid = :uid")
    LiveData<UserEntity> retrieveUserByUid(int uid);

    @Query("Select uploaded from user")
    LiveData<Boolean> isUploaded();

    @Query("UPDATE user SET uploaded=:uploaded WHERE uid = :uid")
    void setUploaded(boolean uploaded, int uid);

    @Update
    void updateUser(UserEntity userEntity);

    @Delete
    void deleteUser(UserEntity userEntity);

}
