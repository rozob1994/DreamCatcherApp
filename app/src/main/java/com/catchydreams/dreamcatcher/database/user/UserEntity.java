package com.catchydreams.dreamcatcher.database.user;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.catchydreams.dreamcatcher.parameters.Users;

@Entity(tableName = "user")
public class UserEntity {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "uid")
    public int uid;

    @ColumnInfo(name = "level")
    public int level;

    @ColumnInfo(name = "email")
    public String username;

    @ColumnInfo(name = "language")
    public String language;

    public UserEntity(){}

    public UserEntity(String language){
        Users user = Users.getInstance();
        this.uid = user.getUid();
        this.level = user.getLevel();
        this.username = user.getEmail();
        this.language = language;
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

    public String getLanguage(){
        return this.language;
    }

}
