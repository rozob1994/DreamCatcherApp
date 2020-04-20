package com.phrenologue.dreamcatcherapp.managersAndFilters;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDate;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;

public class SharedPreferencesManager implements ISharedPreferencesManager {
    public SharedPreferencesManager() {

    }


    public void delDreamFromSp(Context context) {
        SharedPreferences sp = context.getSharedPreferences("dream", Context.MODE_PRIVATE);
        sp.edit().putBoolean("dreamExists", false).apply();
        SharedPreferences spTwo = context.getSharedPreferences("dreamTwo", Context.MODE_PRIVATE);
        spTwo.edit().clear().apply();
        sp.edit().clear().apply();
    }

    public static boolean dreamIsLoaded(Context context) {
        SharedPreferences sp = context.getSharedPreferences("dream", Context.MODE_PRIVATE);
        return sp.getBoolean("dreamExists", false);
    }

    public int getPostIdFromSp(Context context) {
        SharedPreferences sp = context.getSharedPreferences("dream", Context.MODE_PRIVATE);
        return sp.getInt("postId", 0);
    }

    public static void clearDreamSleepQuest(Context context) {
        SharedPreferences sleepSp = context.getSharedPreferences("sleep", Context.MODE_PRIVATE);
        SharedPreferences dreamOneSp = context.getSharedPreferences("dream", Context.MODE_PRIVATE);
        SharedPreferences dreamTwoSp = context.getSharedPreferences("dreamTwo", Context.MODE_PRIVATE);
        SharedPreferences questionnaireSp = context.getSharedPreferences("questionnaire", Context.MODE_PRIVATE);

        sleepSp.edit().clear().apply();
        dreamOneSp.edit().clear().apply();
        dreamTwoSp.edit().clear().apply();
        questionnaireSp.edit().clear().apply();
    }

    @Override
    public void saveSleep(SharedPreferences sp) {
        Sleep sleep = Sleep.getInstance();

        if (sleep.getTime() == 1) {
            sp.edit().putBoolean("day", true).apply();
            sp.edit().putBoolean("night", false).apply();
        } else if (sleep.getTime() == 2) {
            sp.edit().putBoolean("day", false).apply();
            sp.edit().putBoolean("night", true).apply();
        }

        if (sleep.getPhysicalActivity() > 0) {
            sp.edit().putBoolean("hasPhysicalActivity", true).apply();
            sp.edit().putInt("physicalActivity", sleep.getPhysicalActivity()).apply();
        }

        if (sleep.getFoodConsumption() > 0) {
            sp.edit().putBoolean("hasFoodConsumption", true).apply();
            sp.edit().putInt("foodConsumption", sleep.getFoodConsumption()).apply();
        }
    }

    @Override
    public void saveDream(SharedPreferences sp, SharedPreferences spTwo) {
        Dream dream = Dream.getInstance();
        DreamDate date = DreamDate.getInstance();

        sp.edit().putBoolean("dreamExists", true).apply();

        int postId = dream.getPostId();
        Log.e("","");
        Integer grayscale = dream.getDreamChecklist().getGrayScale();
        Integer experience = dream.getDreamChecklist().getExperience();
        Integer lucidityLevel = dream.getDreamLucidity().getLucidityLevel();
        Integer peopleExist = dream.getDreamPeople().getExistent();
        Integer sound = dream.getDreamSound().getSound();
        Integer musical = dream.getDreamSound().getMusical();
        Integer dayOfMonth = date.getDayOfMonth();
        Integer month = date.getMonth();
        int year = date.getYear();

        String title = dream.getDreamDescription().getTitle();
        String content = dream.getDreamDescription().getContent();
        String interpretation = dream.getDreamInterpretation().getInterpretation();

        sp.edit().putInt("postId", postId).apply();
        if (grayscale == 1) {
            sp.edit().putBoolean("hasGray", true).apply();
        } else if (grayscale == 2) {
            sp.edit().putBoolean("hasColor", true).apply();
        }
        sp.edit().putInt("grayScale", grayscale).apply();
        sp.edit().putBoolean("hasMood", true).apply();
        sp.edit().putInt("mood", experience).apply();
        sp.edit().putInt("lucidity", lucidityLevel).apply();
        if (lucidityLevel > 0) {
            sp.edit().putBoolean("hasLucidity", true).apply();
        }
        if (peopleExist == 1) {
            sp.edit().putBoolean("hasPeople", true).apply();
        }

        if (sound == 1) {
            sp.edit().putBoolean("hasSound", true).apply();
        }
        sp.edit().putInt("musical", musical).apply();
        if (musical == 1) {
            sp.edit().putBoolean("hasNonMusic", true).apply();
        } else if (musical == 2) {
            sp.edit().putBoolean("hasMusic", true).apply();
        }
        spTwo.edit().putInt("day", dayOfMonth).apply();
        spTwo.edit().putInt("month", month).apply();
        spTwo.edit().putInt("year", year).apply();

        spTwo.edit().putBoolean("descriptionTitleExists", true).apply();
        spTwo.edit().putString("descriptionTitle", title).apply();
        spTwo.edit().putBoolean("descriptionExists", true).apply();
        spTwo.edit().putString("description", content).apply();
        spTwo.edit().putBoolean("interpretationExists", true).apply();
        spTwo.edit().putString("interpretation", interpretation).apply();
    }

    @Override
    public void savePeople(SharedPreferences sp) {
        DreamPeople people = DreamPeople.getInstance();

        if (!people.getName(0).equals("")) {
            sp.edit().putBoolean("hasPeople", true).apply();
        }

        for (int i = 0; i < 10; i++) {
            if (people.getImpression(i) > 0) {
                sp.edit().putBoolean("hasImpression" + i + "", true).apply();
                sp.edit().putInt("impression" + i + "", people.getImpression(i))
                        .apply();
            }

        }

        for (int i = 0; i < 10; i++) {
            if (!people.getName(i).equals("")) {
                sp.edit().putBoolean("hasName" + i + "", true).apply();
                sp.edit().putString("name" + i + "", people.getName(i)).apply();
            }
        }
    }
}
