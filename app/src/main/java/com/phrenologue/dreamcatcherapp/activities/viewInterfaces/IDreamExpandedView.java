package com.phrenologue.dreamcatcherapp.activities.viewInterfaces;

import com.github.mikephil.charting.data.PieData;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;

public interface IDreamExpandedView<T> {

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
    void onSuccess(T responseMessage);
    void onError();
    void onLucid();
    void onNonLucid();
    void setPercentage(String percentage);
    void drawChart(PieData pieData);
    void setPersianFont();
    void setPersianNameFonts(MoonTextView name);
}
