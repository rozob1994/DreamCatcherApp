package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

public class DreamChecklist {
    private static DreamChecklist instance = new DreamChecklist();
    private Integer grayScale; // 0 = null, 1 = grayscale, 2 = colorful.
    private Integer experience = 0; // 0 = sad, 1 = pokerFace, 2 = happy

    private DreamChecklist() {
    }


    public static void delChecklist() {

        instance = null;
    }

    public static DreamChecklist getInstance(){
        return instance;
    }

    public Integer getGrayScale() {
        return grayScale;
    }

    public void setGrayScale(int grayScale) {
        this.grayScale = grayScale;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
