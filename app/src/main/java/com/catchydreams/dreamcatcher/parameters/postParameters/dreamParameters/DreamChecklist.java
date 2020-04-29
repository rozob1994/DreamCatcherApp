package com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters;

public class DreamChecklist {
    private static DreamChecklist instance = null;
    private Integer grayScale = 0; // 0 = null, 1 = grayscale, 2 = colorful.
    private Integer experience = 0; // 0 = sad, 1 = pokerFace, 2 = happy

    private DreamChecklist() {
    }

    public static DreamChecklist getInstance() {
        if (instance == null){
            instance = new DreamChecklist();
        }
        return instance;
    }

    public static void delChecklist() {

        instance = null;
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
