package com.phrenologue.dreamcatcherapp.activities.viewInterfaces;

public interface IDreamExpandedView {

    void showProgressBar();
    void hideProgressBar();
    void setPeopleView(int index, String name, int textColor);
    void setMoodView(int drawable);
    void hideMood();
    void setSleepTimeView(int drawable);
    void hideSleepTime();
    void setColorView(int drawable);
}
