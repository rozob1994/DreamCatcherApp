package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import androidx.annotation.Nullable;

public class DreamChecklist {
    private static final DreamChecklist instance = new DreamChecklist();
    private int remembered; // 0 = forgotten, 1 = remembered.
    private int falseAwake;
    private int grayScale; // 0 = null, 1 = grayscale, 2 = colorful.
    private int dailyRelated = 0;
    private int experience = 0;

    private DreamChecklist() {
    }


    private DreamChecklist(@Nullable int remembered, @Nullable int falseAwake, @Nullable int grayScale,
                           @Nullable int dailyRelated, @Nullable int experience) {
        this.remembered = remembered;
        this.falseAwake = falseAwake;
        this.grayScale = grayScale;
        this.dailyRelated = dailyRelated;
        this.experience = experience;
    }

    public static DreamChecklist getInstance(){
        return instance;
    }

    public int getRemembered() {
        return remembered;
    }

    public void setRemembered(int remembered) {
        this.remembered = remembered;
    }

    public int getFalseAwake() {
        return falseAwake;
    }

    public void setFalseAwake(int falseAwake) {
        this.falseAwake = falseAwake;
    }

    public int getGrayScale() {
        return grayScale;
    }

    public void setGrayScale(int grayScale) {
        this.grayScale = grayScale;
    }

    public int getDailyRelated() {
        return dailyRelated;
    }

    public void setDailyRelated(int dailyRelated) {
        this.dailyRelated = dailyRelated;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
