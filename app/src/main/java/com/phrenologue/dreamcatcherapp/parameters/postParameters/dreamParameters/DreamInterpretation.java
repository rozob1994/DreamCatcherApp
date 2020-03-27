package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

public class DreamInterpretation {
    public static DreamInterpretation instance = null;
    private String interpretation;


    public static DreamInterpretation getInstance() {
        if (instance == null){
            instance = new DreamInterpretation();
        }
        return instance;
    }

    public static void delDream() {
        instance = null;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }
}
