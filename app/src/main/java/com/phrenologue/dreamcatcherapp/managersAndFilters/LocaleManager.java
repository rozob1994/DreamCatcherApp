package com.phrenologue.dreamcatcherapp.managersAndFilters;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

public class LocaleManager {


    class LocalManager {

    }

    public void setAppLocale (Context context, String localeCode){
        Resources resources= context.getResources();
        DisplayMetrics displayMetrics= resources.getDisplayMetrics();
        Configuration configuration= context.getApplicationContext().getResources().getConfiguration();
        configuration.setLocale(new Locale(localeCode.toLowerCase()));
        resources.updateConfiguration(configuration, displayMetrics);
    }

}