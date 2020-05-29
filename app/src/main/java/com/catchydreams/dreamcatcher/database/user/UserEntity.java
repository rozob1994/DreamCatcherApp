package com.catchydreams.dreamcatcher.database.user;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.catchydreams.dreamcatcher.parameters.Users;

@Entity(tableName = "user")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "uid")
    public int uid;

    @ColumnInfo(name = "level")
    public int level;

    @ColumnInfo(name = "email")
    public String username;

    @ColumnInfo
    private boolean uploaded;

    public UserEntity(){
        Users user = Users.getInstance();
        this.uid = user.getUid();
        this.level = user.getLevel();
        this.username = user.getEmail();
    }

    public int getUid(){
        return this.uid;
    }

    public int getLevel(){
        return this.level;
    }

    public String getUserName(){
        return this.username;
    }


    public boolean isUploaded() {
        return uploaded;
    }

    public void setUploaded(boolean uploaded) {
        this.uploaded = uploaded;
    }
}
