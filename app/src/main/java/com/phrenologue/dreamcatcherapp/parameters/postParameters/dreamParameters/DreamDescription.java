package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;

public class DreamDescription {
    private static DreamDescription instance = null;
    private String title = "";
    private String content = "";
    private DreamDescription(){}
    public static void delDescription() {

        instance = null;
    }

    public static DreamDescription getInstance() {
        if (instance == null){
            instance = new DreamDescription();
        }
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
