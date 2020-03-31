package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

public class DreamLucidity {
    private static DreamLucidity instance = new DreamLucidity();
    private int lucid;
    private int lucidityLevel = 0;

    private DreamLucidity() {
    }

    public static void delLucidity() {

        instance = null;
    }

    public static DreamLucidity getInstance(){
        return instance;
    }

    public int getLucid() {
        return lucid;
    }

    public void setLucid(int lucid) {
        this.lucid = lucid;
    }

    public int getLucidityLevel() {
        return lucidityLevel;
    }

    public void setLucidityLevel(int lucidityLevel) {
        this.lucidityLevel = lucidityLevel;
    }
}
