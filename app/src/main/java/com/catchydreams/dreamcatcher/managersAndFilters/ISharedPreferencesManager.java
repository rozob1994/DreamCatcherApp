package com.catchydreams.dreamcatcher.managersAndFilters;

import android.content.SharedPreferences;

public interface ISharedPreferencesManager {
    void saveSleep(SharedPreferences sp);
    void saveDream(SharedPreferences sp, SharedPreferences spTwo);
    void savePeople(SharedPreferences sp);
}