package com.phrenologue.dreamcatcherapp;

import android.app.Application;
import android.content.Context;

import com.phrenologue.dreamcatcherapp.managersAndFilters.LocaleManager;

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleManager.onAttach(newBase, "en"));
    }
}
