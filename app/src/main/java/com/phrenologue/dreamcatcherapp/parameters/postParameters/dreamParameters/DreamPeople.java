package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import java.util.Arrays;
import java.util.List;

public class DreamPeople {
    private static DreamPeople instance = new DreamPeople();
    private String firstName = "";
    private String secondName = "";
    private String thirdName = "";
    private String fourthName = "";
    private String fifthName = "";
    private String sixthName = "";
    private String seventhName = "";
    private String eighthName = "";
    private String ninthName = "";
    private String tenthName = "";
    private int existent; // 0 = non-existent, 1 = existent.
    private int firstImpression; // 0 = null, 1 = negative, 2 = neutral, 3 = positive.
    private int secondImpression; // 0 = null, 1 = negative, 2 = neutral, 3 = positive.
    private int thirdImpression; // 0 = null, 1 = negative, 2 = neutral, 3 = positive.
    private int fourthImpression; // 0 = null, 1 = negative, 2 = neutral, 3 = positive.
    private int fifthImpression; // 0 = null, 1 = negative, 2 = neutral, 3 = positive.
    private int sixthImpression; // 0 = null, 1 = negative, 2 = neutral, 3 = positive.
    private int seventhImpression; // 0 = null, 1 = negative, 2 = neutral, 3 = positive.
    private int eighthImpression; // 0 = null, 1 = negative, 2 = neutral, 3 = positive.
    private int ninthImpression; // 0 = null, 1 = negative, 2 = neutral, 3 = positive.
    private int tenthImpression; // 0 = null, 1 = negative, 2 = neutral, 3 = positive.

    private DreamPeople() {
    }

    public static void delPeople() {

        instance = null;
    }

    public static DreamPeople getInstance(){
        return instance;
    }

    public void setImpression(int index, int value){
        List<Integer> impressionList = Arrays.asList(this.firstImpression, this.secondImpression,
                this.thirdImpression, this.fourthImpression, this.fifthImpression,
                this.sixthImpression, this.seventhImpression, this.eighthImpression,
                this.ninthImpression, this.tenthImpression);
        value = impressionList.get(index);
    }
    public void setName(int index, String value){
        List<String> namesList = Arrays.asList(this.firstName, this.secondName, this.thirdName,
                this.fourthName, this.fifthName, this.sixthName, this.seventhName, this.eighthName,
                this.ninthName, this.tenthName);
        value = namesList.get(index);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getFourthName() {
        return fourthName;
    }

    public void setFourthName(String fourthName) {
        this.fourthName = fourthName;
    }

    public String getFifthName() {
        return fifthName;
    }

    public void setFifthName(String fifthName) {
        this.fifthName = fifthName;
    }

    public String getSixthName() {
        return sixthName;
    }

    public void setSixthName(String sixthName) {
        this.sixthName = sixthName;
    }

    public String getSeventhName() {
        return seventhName;
    }

    public void setSeventhName(String seventhName) {
        this.seventhName = seventhName;
    }

    public String getEighthName() {
        return eighthName;
    }

    public void setEighthName(String eighthName) {
        this.eighthName = eighthName;
    }

    public String getNinthName() {
        return ninthName;
    }

    public void setNinthName(String ninthName) {
        this.ninthName = ninthName;
    }

    public String getTenthName() {
        return tenthName;
    }

    public void setTenthName(String tenthName) {
        this.tenthName = tenthName;
    }

    public int getExistent() {
        return existent;
    }

    public void setExistent(int existent) {
        this.existent = existent;
    }

    public int getFirstImpression() {
        return firstImpression;
    }

    public void setFirstImpression(int firstImpression) {
        this.firstImpression = firstImpression;
    }

    public int getSecondImpression() {
        return secondImpression;
    }

    public void setSecondImpression(int secondImpression) {
        this.secondImpression = secondImpression;
    }

    public int getThirdImpression() {
        return thirdImpression;
    }

    public void setThirdImpression(int thirdImpression) {
        this.thirdImpression = thirdImpression;
    }

    public int getFourthImpression() {
        return fourthImpression;
    }

    public void setFourthImpression(int fourthImpression) {
        this.fourthImpression = fourthImpression;
    }

    public int getFifthImpression() {
        return fifthImpression;
    }

    public void setFifthImpression(int fifthImpression) {
        this.fifthImpression = fifthImpression;
    }

    public int getSixthImpression() {
        return sixthImpression;
    }

    public void setSixthImpression(int sixthImpression) {
        this.sixthImpression = sixthImpression;
    }

    public int getSeventhImpression() {
        return seventhImpression;
    }

    public void setSeventhImpression(int seventhImpression) {
        this.seventhImpression = seventhImpression;
    }

    public int getEighthImpression() {
        return eighthImpression;
    }

    public void setEighthImpression(int eighthImpression) {
        this.eighthImpression = eighthImpression;
    }

    public int getNinthImpression() {
        return ninthImpression;
    }

    public void setNinthImpression(int ninthImpression) {
        this.ninthImpression = ninthImpression;
    }

    public int getTenthImpression() {
        return tenthImpression;
    }

    public void setTenthImpression(int tenthImpression) {
        this.tenthImpression = tenthImpression;
    }
}
