package com.catchydreams.dreamcatcher.database.user;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    public UserEntity(int uid, int level, String username, String language){
        this.uid = uid;
        this.level = level;
        this.username = username;
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
