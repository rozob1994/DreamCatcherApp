package com.catchydreams.dreamcatcher.managersAndFilters;

import android.content.Context;
import android.content.Intent;

import com.catchydreams.dreamcatcher.activities.LucidDreamingQuestionnaireActivity;
import com.catchydreams.dreamcatcher.activities.profile.ProfileActivity;
import com.catchydreams.dreamcatcher.activities.SleepDreamInputActivity;

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

    public static void goToQuestionnaireFromProfile(Context context, boolean languageChanged){
        Intent intent = new Intent(context, LucidDreamingQuestionnaireActivity.class);
        intent.putExtra("languageChanged", languageChanged);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }
}
