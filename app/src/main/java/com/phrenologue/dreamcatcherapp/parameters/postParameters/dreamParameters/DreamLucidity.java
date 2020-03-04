package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import androidx.annotation.Nullable;

public class DreamLucidity {
    private static final DreamLucidity instance = new DreamLucidity();
    private boolean lucid = false;
    private int lucidityLevel = 0;

    private DreamLucidity() {
    }

    private DreamLucidity(@Nullable boolean lucid, @Nullable int lucidityLevel) {
        this.lucid = lucid;
        this.lucidityLevel = lucidityLevel;
    }

    public static DreamLucidity getInstance(){
        return instance;
    }

    public boolean isLucid() {
        return lucid;
    }

    public void setLucid(boolean lucid) {
        this.lucid = lucid;
    }

    public int getLucidityLevel() {
        return lucidityLevel;
    }

    public void setLucidityLevel(int lucidityLevel) {
        this.lucidityLevel = lucidityLevel;
    }
}
