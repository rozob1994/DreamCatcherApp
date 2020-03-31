package com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters;

import androidx.annotation.Nullable;

import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDate;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamInterpretation;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;

import java.util.Random;


public class Dream {
    private static Dream instance =null;
    private DreamPeople dreamPeople;
    private DreamSound dreamSound;
    private DreamChecklist dreamChecklist;
    private DreamLucidity dreamLucidity;
    private DreamDescription dreamDescription;
    private DreamInterpretation dreamInterpretation;
    private int postId;

    private Dream() {
    }

    private Dream(@Nullable DreamPeople dreamPeople, @Nullable DreamSound dreamSound, @Nullable DreamLucidity dreamLucidity,
                  @Nullable DreamChecklist dreamChecklist, @Nullable DreamDescription dreamDescription) {
        this.dreamPeople = dreamPeople;
        this.dreamSound = dreamSound;
        this.dreamLucidity = dreamLucidity;
        this.dreamDescription = dreamDescription;
        this.dreamChecklist = dreamChecklist;
    }

    public static Dream getInstance() {
        if (instance == null){
            instance = new Dream();
        }
        return instance;
    }

    public static void delDream() {
        DreamDescription.delDescription();
        DreamDate.delDreamDate();
        DreamChecklist.delChecklist();
        DreamInterpretation.delInterpretation();
        DreamLucidity.delLucidity();
        DreamPeople.delPeople();
        DreamSound.delSound();
        instance = null;
    }


    public DreamPeople getDreamPeople() {
        return dreamPeople;
    }

    public void setDreamPeople(DreamPeople dreamPeople) {
        this.dreamPeople = dreamPeople;
    }

    public DreamSound getDreamSound() {
        return dreamSound;
    }

    public void setDreamSound(DreamSound dreamSound) {
        this.dreamSound = dreamSound;
    }

    public DreamLucidity getDreamLucidity() {
        return dreamLucidity;
    }

    public void setDreamLucidity(DreamLucidity dreamLucidity) {
        this.dreamLucidity = dreamLucidity;
    }

    public DreamChecklist getDreamChecklist() {
        return dreamChecklist;
    }

    public void setDreamChecklist(DreamChecklist dreamChecklist) {
        this.dreamChecklist = dreamChecklist;
    }

    public DreamDescription getDreamDescription() {
        return dreamDescription;
    }

    public void setDreamDescription(DreamDescription dreamDescription) {
        this.dreamDescription = dreamDescription;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int generatePostId(){
        Random rand = new Random();
        int randInt = rand.nextInt(999999999);
        this.postId = randInt;
        return postId;
    }

    public DreamInterpretation getDreamInterpretation() {
        return dreamInterpretation;
    }

    public void setDreamInterpretation(DreamInterpretation dreamInterpretation) {
        this.dreamInterpretation = dreamInterpretation;
    }
}

