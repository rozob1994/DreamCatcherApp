package com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters;

import androidx.annotation.Nullable;

import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamTags;

import java.util.Random;


public class Dream {
    private static Dream instance =null;
    private DreamPeople dreamPeople;
    private DreamSound dreamSound;
    private DreamChecklist dreamChecklist;
    private DreamLucidity dreamLucidity;
    private DreamDescription dreamDescription;
    //private String inspiration;
    private DreamTags dreamTags;
    private int postId;

    private Dream() {
    }

    private Dream(@Nullable DreamPeople dreamPeople, @Nullable DreamSound dreamSound, @Nullable DreamLucidity dreamLucidity,
                  @Nullable DreamChecklist dreamChecklist, @Nullable DreamDescription dreamDescription,
                  @Nullable DreamTags dreamTags) {
        this.dreamPeople = dreamPeople;
        this.dreamSound = dreamSound;
        this.dreamLucidity = dreamLucidity;
        this.dreamDescription = dreamDescription;
        this.dreamChecklist = dreamChecklist;
        this.dreamTags = dreamTags;
    }

    public static Dream getInstance() {
        if (instance == null){
            instance = new Dream();
        }
        return instance;
    }

    public static void delDream() {
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

    public DreamTags getDreamTags() {
        return dreamTags;
    }

    public void setDreamTags(DreamTags dreamTags) {
        this.dreamTags = dreamTags;
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
}

