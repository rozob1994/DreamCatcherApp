package com.phrenologue.dreamcatcherapp.presenters.presenterInterfaces;

public interface IDreamExpandedPresenter {

    void onSleepRetrieved();
    void onSleepError();

    void onDreamRetrieved(String dateLoaded);
    void onDreamError();

    void onPeopleRetrieved();
    void onPeopleError();
}
