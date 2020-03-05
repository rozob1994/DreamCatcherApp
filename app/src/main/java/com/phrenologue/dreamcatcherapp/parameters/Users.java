package com.phrenologue.dreamcatcherapp.parameters;

import androidx.annotation.Nullable;

import com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters.Date;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;

import java.util.Random;

import javax.inject.Inject;

public class Users {
    private static Users instance = null;
    private String email;
    private int uid;
    int gender;
    String username;
    private Dream dream;
    private Sleep sleep;
    private String password;
    private Date date;

    private Users() {
    }

    @Inject
    public Users(@Nullable Dream dream, @Nullable Sleep sleep, @Nullable Date date) {
        this.setDate(date);
        this.setDream(dream);
        this.setSleep(sleep);
    }

    public static Users getInstance() {
        if (instance == null){
            instance = new Users();
        }
        return instance;
    }

    public static void delUser(){
        instance = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Dream getDream() {
        return dream;
    }

    public void setDream(Dream dream) {
        this.dream = dream;
    }

    public Sleep getSleep() {
        return sleep;
    }

    public void setSleep(Sleep sleep) {
        this.sleep = sleep;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUid() {
        return uid;
    }

    public void generateUid() {
        Random rand = new Random();
        int randInt = rand.nextInt(999999999);
        this.uid = randInt;
    }
    public void setUid(int uid){
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
