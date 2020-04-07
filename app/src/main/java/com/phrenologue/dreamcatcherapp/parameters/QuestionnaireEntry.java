package com.phrenologue.dreamcatcherapp.parameters;

public class QuestionnaireEntry {
    private static QuestionnaireEntry instance = null;
    private int id;
    private int qOne; // 0 = No, 1 = Not Sure, 2 = Yes
    private int qTwo;
    private int qThree;
    private int qFour;
    private int qFive;
    private int qSix;
    private int qSeven;
    private int qEight;
    private int qNine;
    private int qTen;
    private int qEleven;
    private int qTwelve;
    private int qThirteen;
    private int qFourteen;
    private int qFifteen;
    private int qSixteen;
    private int qSeventeen;
    private int qEighteen;
    private int qNineteen;
    private int result;

    private QuestionnaireEntry() {
    }

    public static QuestionnaireEntry getInstance() {
        if (instance == null) {
            instance = new QuestionnaireEntry();
        }
        return instance;
    }

    public static void delQuestionnaireEntry() {
        instance = null;
    }

    public void setAns(int qNumber, int ans) { // 0 = No, 1 = Not Sure, 2 = Yes
        switch (qNumber) {
            case 1:
                setqOne(ans);
                break;
            case 2:
                setqTwo(ans);
                break;
            case 3:
                setqThree(ans);
                break;
            case 4:
                setqFour(ans);
                break;
            case 5:
                setqFive(ans);
                break;
            case 6:
                setqSix(ans);
                break;
            case 7:
                setqSeven(ans);
                break;
            case 8:
                setqEight(ans);
                break;
            case 9:
                setqNine(ans);
                break;
            case 10:
                setqTen(ans);
                break;
            case 11:
                setqEleven(ans);
                break;
            case 12:
                setqTwelve(ans);
                break;
            case 13:
                setqThirteen(ans);
                break;
            case 14:
                setqFourteen(ans);
                break;
            case 15:
                setqFifteen(ans);
                break;
            case 16:
                setqSixteen(ans);
                break;
            case 17:
                setqSeventeen(ans);
                break;
            case 18:
                setqEighteen(ans);
                break;
            case 19:
                setqNineteen(ans);
                break;
        }
    }

    public int getqOne() {
        return qOne;
    }

    private void setqOne(int qOne) {
        this.qOne = qOne;
    }

    public int getqTwo() {
        return qTwo;
    }

    private void setqTwo(int qTwo) {
        this.qTwo = qTwo;
    }

    public int getqThree() {
        return qThree;
    }

    private void setqThree(int qThree) {
        this.qThree = qThree;
    }

    public int getqFour() {
        return qFour;
    }

    private void setqFour(int qFour) {
        this.qFour = qFour;
    }

    public int getqFive() {
        return qFive;
    }

    private void setqFive(int qFive) {
        this.qFive = qFive;
    }

    public int getqSix() {
        return qSix;
    }

    private void setqSix(int qSix) {
        this.qSix = qSix;
    }

    public int getqSeven() {
        return qSeven;
    }

    private void setqSeven(int qSeven) {
        this.qSeven = qSeven;
    }

    public int getqEight() {
        return qEight;
    }

    private void setqEight(int qEight) {
        this.qEight = qEight;
    }

    public int getqNine() {
        return qNine;
    }

    private void setqNine(int qNine) {
        this.qNine = qNine;
    }

    public int getqTen() {
        return qTen;
    }

    private void setqTen(int qTen) {
        this.qTen = qTen;
    }

    public int getqEleven() {
        return qEleven;
    }

    private void setqEleven(int qEleven) {
        this.qEleven = qEleven;
    }

    public int getqTwelve() {
        return qTwelve;
    }

    private void setqTwelve(int qTwelve) {
        this.qTwelve = qTwelve;
    }

    public int getqThirteen() {
        return qThirteen;
    }

    private void setqThirteen(int qThirteen) {
        this.qThirteen = qThirteen;
    }

    public int getqFourteen() {
        return qFourteen;
    }

    private void setqFourteen(int qFourteen) {
        this.qFourteen = qFourteen;
    }

    public int getqFifteen() {
        return qFifteen;
    }

    private void setqFifteen(int qFifteen) {
        this.qFifteen = qFifteen;
    }

    public int getqSixteen() {
        return qSixteen;
    }

    private void setqSixteen(int qSixteen) {
        this.qSixteen = qSixteen;
    }

    public int getqSeventeen() {
        return qSeventeen;
    }

    private void setqSeventeen(int qSeventeen) {
        this.qSeventeen = qSeventeen;
    }

    public int getqEighteen() {
        return qEighteen;
    }

    private void setqEighteen(int qEighteen) {
        this.qEighteen = qEighteen;
    }

    public int getqNineteen() {
        return qNineteen;
    }

    private void setqNineteen(int qNineteen) {
        this.qNineteen = qNineteen;
    }

    public int getResult() {
        return result;
    }

    private float getFloatResult() {
        return result;
    }

    public void setResult() {
        int result = getqOne() + getqTwo() + getqThree() + getqFour() + getqFive() + getqSix() +
                getqSeven() + getqEight() + getqNine() + getqTen() + getqEleven() + getqTwelve() +
                getqThirteen() + getqFourteen() + getqFifteen() + getqSixteen() + getqSeventeen() +
                getqEighteen() + getqNineteen();
        this.result = result;
    }

    public float getResultPercentage() {
        return (100 * (getFloatResult() / 38f));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
