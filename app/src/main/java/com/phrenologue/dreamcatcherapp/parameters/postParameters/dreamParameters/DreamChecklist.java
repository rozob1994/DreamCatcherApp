package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

public class DreamChecklist {
    private static DreamChecklist instance = new DreamChecklist();
    private int remembered; // 0 = forgotten, 1 = remembered.
    private int grayScale; // 0 = null, 1 = grayscale, 2 = colorful.
    private int experience = 0;

    private DreamChecklist() {
    }


    public static void delChecklist() {

        instance = null;
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

    public int getGrayScale() {
        return grayScale;
    }

    public void setGrayScale(int grayScale) {
        this.grayScale = grayScale;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
