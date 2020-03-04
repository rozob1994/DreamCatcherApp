package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import androidx.annotation.Nullable;

public class DreamSound {
    private static final DreamSound instance = new DreamSound();
    private boolean sound = false;
    private boolean musical = false;

    private DreamSound() {
    }

    private DreamSound(@Nullable boolean sound, @Nullable boolean musical) {
        this.sound = sound;
        this.musical = musical;
    }

    public static DreamSound getInstance(){
        return instance;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public boolean isMusical() {
        return musical;
    }

    public void setMusical(boolean musical) {
        this.musical = musical;
    }
}
