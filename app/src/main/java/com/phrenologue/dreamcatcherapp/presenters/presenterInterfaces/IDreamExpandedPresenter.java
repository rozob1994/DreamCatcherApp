package com.phrenologue.dreamcatcherapp.presenters.presenterInterfaces;

public interface IDreamExpandedPresenter {

    void onSleepRetrieved();

    void onDreamRetrieved(String dateLoaded);

    void onPeopleRetrieved();

    void checkLucidity(int result);

    void onError();
}
