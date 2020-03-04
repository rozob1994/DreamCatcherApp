package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import androidx.annotation.Nullable;

public class DreamPeople {
    private static final DreamPeople instance = new DreamPeople();
    private String name = "";
    private boolean existent = false;
    private int impression = 0;

    private DreamPeople() {
    }

    private DreamPeople(@Nullable String name, @Nullable boolean existent, @Nullable int impression) {
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

    public boolean isExistent() {
        return existent;
    }

    public void setExistent(boolean existent) {
        this.existent = existent;
    }

    public int getImpression() {
        return impression;
    }

    public void setImpression(int impression) {
        this.impression = impression;
    }
}
