package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

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
        switch (index){
            case 0:
                setFirstImpression(value);
            case 1:
                setSecondImpression(value);
            case 2:
                setThirdImpression(value);
            case 3:
                setFourthImpression(value);
            case 4:
                setFifthImpression(value);
            case 5:
                setSixthImpression(value);
            case 6:
                setSeventhImpression(value);
            case 7:
                setEighthImpression(value);
            case 8:
                setNinthImpression(value);
            case 9:
                setTenthImpression(value);
        }
    }
    public void setName(int index, String value){
        switch (index){
            case 0:
                setFirstName(value);
            case 1:
                setSecondName(value);
            case 2:
                setThirdName(value);
            case 3:
                setFourthName(value);
            case 4:
                setFifthName(value);
            case 5:
                setSixthName(value);
            case 6:
                setSeventhName(value);
            case 7:
                setEighthName(value);
            case 8:
                setNinthName(value);
            case 9:
                setTenthName(value);
        }
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
