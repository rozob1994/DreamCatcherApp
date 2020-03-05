package com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters;

import androidx.annotation.Nullable;

public class Sleep {
    private static Sleep instance = null;
    private String duration = "";
    private int time = 0;  // 0 = no input, 1 = day, 2 = night
    private int physicalActivity = 0;
    private int foodConsumption = 0;
    private boolean sleepParalysis = false;



    private Sleep() {
    }

    private Sleep(@Nullable String duration, @Nullable int time, @Nullable int physicalActivity,
                  @Nullable int foodConsumption, @Nullable boolean sleepParalysis) {
        this.duration = duration;
        this.time = time;
        this.physicalActivity = physicalActivity;
        this.foodConsumption = foodConsumption;
        this.sleepParalysis = sleepParalysis;
    }

    public static Sleep getInstance() {
        if (instance == null) {
            instance = new Sleep();
        }
        return instance;
    }

    public static void delSleep() {
        instance = null;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public boolean getSleepParalysis() {
        return sleepParalysis;
    }

    public void setSleepParalysis(boolean sleepParalysis) {
        this.sleepParalysis = sleepParalysis;
    }
}

