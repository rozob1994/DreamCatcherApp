package com.phrenologue.dreamcatcherapp.presenters.presenterInterfaces;

public interface IDreamPackagesView {

    void showProgressBar();
    void hideProgressBar();
    void onSuccess();
    void onError();
    void setLevelView(String folder, String json);
    void onLanguageChanged();
    void setPersianTypeFace();
}
