package com.phrenologue.dreamcatcherapp.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDate;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;

public class SharedPreferencesManager {
    public SharedPreferencesManager() {

    }

    public void saveDreamToSp(Context context, Dream dream, DreamDate date) {

        SharedPreferences sp = context.getSharedPreferences("dream", Context.MODE_PRIVATE);
        SharedPreferences spTwo = context.getSharedPreferences("dreamTwo", Context.MODE_PRIVATE);

        sp.edit().putBoolean("dreamExists", true).apply();

        int postId = dream.getPostId();
        int grayscale = dream.getDreamChecklist().getGrayScale();
        int experience = dream.getDreamChecklist().getExperience();
        int lucidityLevel = dream.getDreamLucidity().getLucidityLevel();
        int peopleExist = dream.getDreamPeople().getExistent();
        int peopleImpression = dream.getDreamPeople().getImpression();
        int sound = dream.getDreamSound().getSound();
        int musical = dream.getDreamSound().getMusical();
        int dayOfMonth = date.getDayOfMonth();
        int month = date.getMonth();
        int year = date.getYear();

        String title = dream.getDreamDescription().getTitle();
        String content = dream.getDreamDescription().getContent();
        String interpretation = dream.getDreamInterpretation().getInterpretation();
        String peopleName = dream.getDreamPeople().getName();

        sp.edit().putInt("postId", postId).apply();
        if (grayscale==1){
            sp.edit().putBoolean("hasGray", true).apply();
        } else if (grayscale==2){
            sp.edit().putBoolean("hasColor", true).apply();
        }
        sp.edit().putInt("grayScale", grayscale).apply();
        sp.edit().putBoolean("hasMood", true).apply();
        sp.edit().putInt("mood", experience).apply();
        sp.edit().putInt("lucidity", lucidityLevel).apply();
        if (lucidityLevel > 0) {
            sp.edit().putBoolean("hasLucidity",true).apply();
        }
        if (peopleExist == 1) {
            sp.edit().putBoolean("hasPeople", true).apply();
        }
        if (peopleImpression>0){
            sp.edit().putBoolean("hasImpression", true).apply();
        }
        sp.edit().putInt("impression", peopleImpression).apply();
        if (sound == 1) {
            sp.edit().putBoolean("hasSound", true).apply();
        }
        sp.edit().putInt("musical", musical).apply();
        if (musical==1){
            sp.edit().putBoolean("hasNonMusic", true).apply();
        } else if (musical==2){
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
        sp.edit().putString("peopleName", peopleName).apply();

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

}
