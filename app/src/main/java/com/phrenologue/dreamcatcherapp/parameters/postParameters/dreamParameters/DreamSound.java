package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;

public class DreamSound {
    private static DreamSound instance = null;
    private int sound; // 0 = silent dream, 1 = dream with sound.
    private int musical; // 0 = null, 1 = non-musical dream, 2 = musical dream.

    private DreamSound() {
    }

    public static void delSound() {

        instance = null;
    }
    public static DreamSound getInstance() {
        if (instance == null){
            instance = new DreamSound();
        }
        return instance;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getMusical() {
        return musical;
    }

    public void setMusical(int musical) {
        this.musical = musical;
    }
}
