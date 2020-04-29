package com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class DreamPeople {
    private static DreamPeople instance = null;
    private String name = "";
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
    private int impression = 0;
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
    private int peopleCount = 0;

    private DreamPeople() {
    }

    public static void delPeople() {

        instance = null;
    }

    public static DreamPeople getInstance() {
        if (instance == null){
            instance = new DreamPeople();
        }
        return instance;
    }

    public int getPeopleCount() {
        List<String> names = Arrays.asList(firstName, secondName, thirdName, fourthName, fifthName,
                sixthName, seventhName, eighthName, ninthName, tenthName);
        int count = 0;
        for (int i = 0; i <= names.size(); i++) {
            if (!names.get(i).equals("")) {
                count++;
            }
        }
        return count;
    }

    public int getCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount){
        this.peopleCount = peopleCount;
    }

    public void setImpression(@Nullable Integer index, @Nullable Integer value) {
        if (index != null) {
            if (value != null) {
                switch (index) {
                    case 0:
                        setFirstImpression(value);
                        break;
                    case 1:
                        setSecondImpression(value);
                        break;
                    case 2:
                        setThirdImpression(value);
                        break;
                    case 3:
                        setFourthImpression(value);
                        break;
                    case 4:
                        setFifthImpression(value);
                        break;
                    case 5:
                        setSixthImpression(value);
                        break;
                    case 6:
                        setSeventhImpression(value);
                        break;
                    case 7:
                        setEighthImpression(value);
                        break;
                    case 8:
                        setNinthImpression(value);
                        break;
                    case 9:
                        setTenthImpression(value);
                        break;
                }
            }

        }

    }

    public int getImpression(int index) {
        switch (index) {
            case 0:
                impression = getFirstImpression();
                break;
            case 1:
                impression = getSecondImpression();
                break;
            case 2:
                impression = getThirdImpression();
                break;
            case 3:
                impression = getFourthImpression();
                break;
            case 4:
                impression = getFifthImpression();
                break;
            case 5:
                impression = getSixthImpression();
                break;
            case 6:
                impression = getSeventhImpression();
                break;
            case 7:
                impression = getEighthImpression();
                break;
            case 8:
                impression = getNinthImpression();
                break;
            case 9:
                impression = getTenthImpression();
                break;
        }
        return impression;
    }

    public void setName(int index, String value) {
        switch (index) {
            case 0:
                setFirstName(value);
                break;
            case 1:
                setSecondName(value);
                break;
            case 2:
                setThirdName(value);
                break;
            case 3:
                setFourthName(value);
                break;
            case 4:
                setFifthName(value);
                break;
            case 5:
                setSixthName(value);
                break;
            case 6:
                setSeventhName(value);
                break;
            case 7:
                setEighthName(value);
                break;
            case 8:
                setNinthName(value);
                break;
            case 9:
                setTenthName(value);
                break;
        }
    }

    public String getName(int index) {
        switch (index) {
            case 0:
                name = getFirstName();
                break;
            case 1:
                name = getSecondName();
                break;
            case 2:
                name = getThirdName();
                break;
            case 3:
                name = getFourthName();
                break;
            case 4:
                name = getFifthName();
                break;
            case 5:
                name = getSixthName();
                break;
            case 6:
                name = getSeventhName();
                break;
            case 7:
                name = getEighthName();
                break;
            case 8:
                name = getNinthName();
                break;
            case 9:
                name = getTenthName();
                break;
        }
        return name;
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
