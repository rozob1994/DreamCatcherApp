package com.catchydreams.dreamcatcher.presenters.presenterInterfaces;

import android.content.SharedPreferences;

public interface IDreamExpandedPresenter {

    void onSleepRetrieved();

    void onDreamRetrieved(String dateLoaded);

    void onPeopleRetrieved();

    void checkLucidity(int result, SharedPreferences languagePrefs);

    void onError();
}
