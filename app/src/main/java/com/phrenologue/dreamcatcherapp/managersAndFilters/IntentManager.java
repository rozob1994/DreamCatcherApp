package com.phrenologue.dreamcatcherapp.managersAndFilters;

import android.content.Context;
import android.content.Intent;

import com.phrenologue.dreamcatcherapp.activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.activities.SleepDreamInputActivity;

import maes.tech.intentanim.CustomIntent;

public class IntentManager {
    public IntentManager() {}

    public static void goToProfile(Context context) {
        Intent intent = new Intent(context, ProfileActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        CustomIntent.customType(context, "fadein-to-fadeout");
    }

    public static void goToSleepDreamInput(Context context) {
        Intent intent = new Intent(context, SleepDreamInputActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        CustomIntent.customType(context, "fadein-to-fadeout");
    }
}
