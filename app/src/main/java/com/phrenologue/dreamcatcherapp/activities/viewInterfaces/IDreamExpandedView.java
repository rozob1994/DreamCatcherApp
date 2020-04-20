package com.phrenologue.dreamcatcherapp.activities.viewInterfaces;

public interface IDreamExpandedView {

    void showProgressBar();
    void hideProgressBar();
    void setPeopleView(int index, String name, int textColor);
    void setMoodView(int drawable);
    void hideMood();
    void setSleepTimeView(int drawable);
    void hideSleepTime();
    void setFoodView(int drawable);
    void setPhysicalView(int drawable);
    void setColorView(int drawable);
    void setMusicalView(int drawable);
    void setInterpretationText();
    void setTitleText();
    void setContentText();
    void setDateText(String dateLoaded);

}
