package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import androidx.annotation.Nullable;

public class DreamPeople {
    private static final DreamPeople instance = new DreamPeople();
    private String name = "";
    private int existent; // 0 = non-existent, 1 = existent.
    private int impression; // 0 = null, 1 = negative, 2 = neutral, 3 = positive.

    private DreamPeople() {
    }

    private DreamPeople(@Nullable String name, @Nullable int existent, @Nullable int impression) {
        this.name = name;
        this.existent = existent;
        this.impression = impression;
    }
    public static DreamPeople getInstance(){
        return instance;
    }

    public String getName() {
        if (name == null){
            return null;
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExistent() {
        return existent;
    }

    public void setExistent(int existent) {
        this.existent = existent;
    }

    public int getImpression() {
        return impression;
    }

    public void setImpression(int impression) {
        this.impression = impression;
    }
}
