package com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters;

import androidx.annotation.Nullable;

import java.util.Random;

public class Sleep {
    private static Sleep instance = null;
    private int time = 0;  // 0 = no input, 1 = day, 2 = night
    private int physicalActivity = 0;
    private int foodConsumption = 0;
    private int postId;


    private Sleep() {
    }

    private Sleep(@Nullable int time, @Nullable int physicalActivity,
                  @Nullable int foodConsumption) {
        this.time = time;
        this.physicalActivity = physicalActivity;
        this.foodConsumption = foodConsumption;
    }

    public static Sleep getInstance() {
        if (instance == null) {
            instance = new Sleep();
        }
        return instance;
    }

    public static void setSleepProps(int time, int activity, int food) {
        Sleep sleep = Sleep.getInstance();
        sleep.setTime(time);
        sleep.setPhysicalActivity(activity);
        sleep.setFoodConsumption(food);
    }

    public static void delSleep() {
        instance = null;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {

        this.time = time;
    }

    public int getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(int physicalActivity) {
        this.physicalActivity = physicalActivity;
    }

    public int getFoodConsumption() {
        return foodConsumption;
    }

    public void setFoodConsumption(int foodConsumption) {
        this.foodConsumption = foodConsumption;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int generatePostId(){
        Random rand = new Random();
        int randInt = rand.nextInt(999999999);
        this.postId = randInt;
        return postId;
    }
}

