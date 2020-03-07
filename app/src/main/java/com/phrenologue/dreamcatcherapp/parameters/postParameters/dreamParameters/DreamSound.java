package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import androidx.annotation.Nullable;

public class DreamSound {
    private static final DreamSound instance = new DreamSound();
    private int sound; // 0 = silent dream, 1 = dream with sound.
    private int musical; // 0 = null, 1 = non-musical dream, 2 = musical dream.

    private DreamSound() {
    }

    private DreamSound(@Nullable int sound, @Nullable int musical) {
        this.sound = sound;
        this.musical = musical;
    }

    public static DreamSound getInstance(){
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
