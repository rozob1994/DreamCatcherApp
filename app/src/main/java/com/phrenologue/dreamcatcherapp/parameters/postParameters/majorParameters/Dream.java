package com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters;

import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDate;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamInterpretation;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;

import java.util.Random;


public class Dream {
    private static Dream instance = null;
    private DreamPeople dreamPeople;
    private DreamSound dreamSound;
    private DreamChecklist dreamChecklist;
    private DreamLucidity dreamLucidity;
    private DreamDescription dreamDescription;
    private DreamInterpretation dreamInterpretation;
    private int postId;

    private Dream() {
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

    public static void setDreamProperties(int grayScale, int experience, int dayOfMonth,
                                          int month, int year, String title, String content,
                                          String interpretationTxt, int lucidityLevel,
                                          int existent, int soundInput, int musical) {
        DreamChecklist checklist = DreamChecklist.getInstance();
        DreamDate date = DreamDate.getInstance();
        DreamDescription description = DreamDescription.getInstance();
        DreamInterpretation interpretation = DreamInterpretation.getInstance();
        DreamLucidity lucidity = DreamLucidity.getInstance();
        DreamPeople people = DreamPeople.getInstance();
        DreamSound sound = DreamSound.getInstance();
        Dream dream = Dream.getInstance();

        checklist.setGrayScale(grayScale);
        checklist.setExperience(experience);
        date.setDayOfMonth(dayOfMonth);
        date.setMonth(month);
        date.setYear(year);
        description.setTitle(title);
        description.setContent(content);
        interpretation.setInterpretation(interpretationTxt);
        lucidity.setLucidityLevel(lucidityLevel);
        people.setExistent(existent);
        sound.setSound(soundInput);
        sound.setMusical(musical);

        dream.setDreamChecklist(checklist);
        dream.setDreamDescription(description);
        dream.setDreamInterpretation(interpretation);
        dream.setDreamLucidity(lucidity);
        dream.setDreamPeople(people);
        dream.setDreamSound(sound);
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

