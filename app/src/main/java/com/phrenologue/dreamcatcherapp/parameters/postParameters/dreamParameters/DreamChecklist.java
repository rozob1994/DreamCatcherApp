package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import androidx.annotation.Nullable;

public class DreamChecklist {
    private static final DreamChecklist instance = new DreamChecklist();
    private boolean remembered = false;
    private boolean falseAwake = false;
    private boolean grayScale = false;
    private int dailyRelated = 0;
    private int experience = 0;

    private DreamChecklist() {
    }


    private DreamChecklist(@Nullable boolean remembered, @Nullable boolean falseAwake, @Nullable boolean grayScale,
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

    public boolean isRemembered() {
        return remembered;
    }

    public void setRemembered(boolean remembered) {
        this.remembered = remembered;
    }

    public boolean isFalseAwake() {
        return falseAwake;
    }

    public void setFalseAwake(boolean falseAwake) {
        this.falseAwake = falseAwake;
    }

    public boolean isGrayScale() {
        return grayScale;
    }

    public void setGrayScale(boolean grayScale) {
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
