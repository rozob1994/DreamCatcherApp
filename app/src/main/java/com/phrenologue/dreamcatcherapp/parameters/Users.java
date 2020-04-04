package com.phrenologue.dreamcatcherapp.parameters;

import com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters.Date;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;

import java.util.Random;

public class Users {
    private static Users instance = null;
    private String email;
    private int uid;
    private int level;
    int gender;
    String username;
    private Dream dream;
    private Sleep sleep;
    private String password;
    private Date date;
    public static int levelTwoScore = 6, levelThreeScore = 18, levelFourScore = 66,
            levelFiveScore = 162, levelSixScore = 354, levelSevenScore = 738, levelEightScore = 1506,
            levelNineScore = 3042, levelTenScore = 6114;


    private Users() {
    }


    public static Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }

    public static void delUser() {
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

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void calculateSetLevel(int dreamCount, int sleepCount, int lucidityCount) {
        Levels level = Levels.getInstance();
        int score = dreamCount + sleepCount + lucidityCount;
        level.setLevel(score);
        if (score < levelTwoScore) {
            this.level = 1;
        } else if (score < levelThreeScore) {
            this.level = 2;
        } else if (score < levelFourScore) {
            this.level = 3;
        } else if (score < levelFiveScore) {
            this.level = 4;
        } else if (score < levelSixScore) {
            this.level = 5;
        } else if (score < levelSevenScore) {
            this.level = 6;
        } else if (score < levelEightScore) {
            this.level = 7;
        } else if (score < levelNineScore) {
            this.level = 8;
        } else if (score < levelTenScore) {
            this.level = 9;
        } else if (score >levelTenScore) {
            this.level = 10;
        }
    }
}
