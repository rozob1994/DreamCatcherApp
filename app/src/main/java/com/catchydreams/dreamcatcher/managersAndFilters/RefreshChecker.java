package com.catchydreams.dreamcatcher.managersAndFilters;

public class RefreshChecker {
    private static RefreshChecker instance = null;
    private boolean started;
    private boolean killed;

    private RefreshChecker() {

    }

    public static RefreshChecker getInstance() {
        if (instance == null) {
            instance = new RefreshChecker();
        }
        return instance;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }
}
