package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import androidx.annotation.Nullable;


public class DreamDescription {
    private static final DreamDescription instance = new DreamDescription();
    private String title = "";
    private String content = "";
    private DreamDescription(){}
    private DreamDescription(@Nullable String title, @Nullable String content) {
        this.content = content;
        this.title = title;
    }

    public static DreamDescription getInstance(){
        return instance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
