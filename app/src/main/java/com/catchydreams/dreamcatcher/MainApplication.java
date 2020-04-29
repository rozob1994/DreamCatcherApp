package com.catchydreams.dreamcatcher;

import android.app.Application;
import android.content.Context;

import com.catchydreams.dreamcatcher.managersAndFilters.LocaleManager;

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleManager.onAttach(newBase, "en"));
    }
}
