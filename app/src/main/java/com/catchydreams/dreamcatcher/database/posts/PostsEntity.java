package com.catchydreams.dreamcatcher.database.posts;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.catchydreams.dreamcatcher.parameters.QuestionnaireEntry;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamChecklist;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamDate;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamDescription;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamInterpretation;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamPeople;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamSound;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Dream;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Sleep;

@Entity(tableName = "posts")
public class PostsEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "postId")
    private int postId;

    @ColumnInfo(name = "sound")
    private int sound;

    @ColumnInfo(name = "musical")
    private int musical;

    @ColumnInfo(name = "grayscale")
    private int grayscale;

    @ColumnInfo(name = "experience")
    private int experience;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "interpretation")
    private String interpretation;

    @ColumnInfo(name = "hasPeople")
    private int hasPeople;

    @ColumnInfo(name = "firstPerson")
    private String firstPerson;
    @ColumnInfo(name = "secondPerson")
    private String secondPerson;
    @ColumnInfo(name = "thirdPerson")
    private String thirdPerson;
    @ColumnInfo(name = "fourthPerson")
    private String fourthPerson;
    @ColumnInfo(name = "fifthPerson")
    private String fifthPerson;
    @ColumnInfo(name = "sixthPerson")
    private String sixthPerson;
    @ColumnInfo(name = "seventhPerson")
    private String seventhPerson;
    @ColumnInfo(name = "eighthPerson")
    private String eighthPerson;
    @ColumnInfo(name = "ninthPerson")
    private String ninthPerson;
    @ColumnInfo(name = "tenthPerson")
    private String tenthPerson;

    @ColumnInfo(name = "firstImpression")
    private int firstImpression;
    @ColumnInfo(name = "secondImpression")
    private int secondImpression;
    @ColumnInfo(name = "thirdImpression")
    private int thirdImpression;
    @ColumnInfo(name = "fourthImpression")
    private int fourthImpression;
    @ColumnInfo(name = "fifthImpression")
    private int fifthImpression;
    @ColumnInfo(name = "sixthImpression")
    private int sixthImpression;
    @ColumnInfo(name = "seventhImpression")
    private int seventhImpression;
    @ColumnInfo(name = "eighthImpression")
    private int eighthImpression;
    @ColumnInfo(name = "ninthImpression")
    private int ninthImpression;
    @ColumnInfo(name = "tenthImpression")
    private int tenthImpression;

    @ColumnInfo(name = "time")
    private int time;

    @ColumnInfo(name = "physicalActivity")
    private int physicalActivity;

    @ColumnInfo(name = "foodConsumption")
    private int foodConsumption;

    @ColumnInfo(name = "q1")
    private int q1;
    @ColumnInfo(name = "q2")
    private int q2;
    @ColumnInfo(name = "q3")
    private int q3;
    @ColumnInfo(name = "q4")
    private int q4;
    @ColumnInfo(name = "q5")
    private int q5;
    @ColumnInfo(name = "q6")
    private int q6;
    @ColumnInfo(name = "q7")
    private int q7;
    @ColumnInfo(name = "q8")
    private int q8;
    @ColumnInfo(name = "q9")
    private int q9;
    @ColumnInfo(name = "q10")
    private int q10;
    @ColumnInfo(name = "q11")
    private int q11;
    @ColumnInfo(name = "q12")
    private int q12;
    @ColumnInfo(name = "q13")
    private int q13;
    @ColumnInfo(name = "q14")
    private int q14;
    @ColumnInfo(name = "q15")
    private int q15;
    @ColumnInfo(name = "q16")
    private int q16;
    @ColumnInfo(name = "q17")
    private int q17;
    @ColumnInfo(name = "q18")
    private int q18;
    @ColumnInfo(name = "q19")
    private int q19;
    @ColumnInfo(name = "result")
    private int result;

    @ColumnInfo(name = "day")
    private int day;

    @ColumnInfo(name = "month")
    private int month;

    @ColumnInfo(name = "year")
    private int year;

    public PostsEntity() {
        this.postId = Dream.getInstance().getPostId();
        this.sound = DreamSound.getInstance().getSound();
        this.musical = DreamSound.getInstance().getMusical();
        this.grayscale = DreamChecklist.getInstance().getGrayScale();
        this.experience = DreamChecklist.getInstance().getExperience();
        this.title = DreamDescription.getInstance().getTitle();
        this.content = DreamDescription.getInstance().getContent();
        this.interpretation = DreamInterpretation.getInstance().getInterpretation();
        this.hasPeople = DreamPeople.getInstance().getExistent();
        this.firstPerson = DreamPeople.getInstance().getFirstName();
        this.secondPerson = DreamPeople.getInstance().getSecondName();
        this.thirdPerson = DreamPeople.getInstance().getThirdName();
        this.fourthPerson = DreamPeople.getInstance().getFourthName();
        this.fifthPerson = DreamPeople.getInstance().getFifthName();
        this.sixthPerson = DreamPeople.getInstance().getSixthName();
        this.seventhPerson = DreamPeople.getInstance().getSeventhName();
        this.eighthPerson = DreamPeople.getInstance().getEighthName();
        this.ninthPerson = DreamPeople.getInstance().getNinthName();
        this.tenthPerson = DreamPeople.getInstance().getTenthName();
        this.firstImpression = DreamPeople.getInstance().getFirstImpression();
        this.secondImpression = DreamPeople.getInstance().getSecondImpression();
        this.thirdImpression = DreamPeople.getInstance().getThirdImpression();
        this.fourthImpression = DreamPeople.getInstance().getFourthImpression();
        this.fifthImpression = DreamPeople.getInstance().getFifthImpression();
        this.sixthImpression = DreamPeople.getInstance().getSixthImpression();
        this.seventhImpression = DreamPeople.getInstance().getSeventhImpression();
        this.eighthImpression = DreamPeople.getInstance().getEighthImpression();
        this.ninthImpression = DreamPeople.getInstance().getNinthImpression();
        this.tenthImpression = DreamPeople.getInstance().getTenthImpression();
        this.time = Sleep.getInstance().getTime();
        this.physicalActivity = Sleep.getInstance().getPhysicalActivity();
        this.foodConsumption = Sleep.getInstance().getFoodConsumption();
        this.q1 = QuestionnaireEntry.getInstance().getqOne();
        this.q2 = QuestionnaireEntry.getInstance().getqTwo();
        this.q3 = QuestionnaireEntry.getInstance().getqThree();
        this.q4 = QuestionnaireEntry.getInstance().getqFour();
        this.q5 = QuestionnaireEntry.getInstance().getqFive();
        this.q6 = QuestionnaireEntry.getInstance().getqSix();
        this.q7 = QuestionnaireEntry.getInstance().getqSeven();
        this.q8 = QuestionnaireEntry.getInstance().getqEight();
        this.q9 = QuestionnaireEntry.getInstance().getqNine();
        this.q10 = QuestionnaireEntry.getInstance().getqTen();
        this.q11 = QuestionnaireEntry.getInstance().getqEleven();
        this.q12 = QuestionnaireEntry.getInstance().getqTwelve();
        this.q13 = QuestionnaireEntry.getInstance().getqThirteen();
        this.q14 = QuestionnaireEntry.getInstance().getqFourteen();
        this.q15 = QuestionnaireEntry.getInstance().getqFifteen();
        this.q16 = QuestionnaireEntry.getInstance().getqSixteen();
        this.q17 = QuestionnaireEntry.getInstance().getqSeventeen();
        this.q18 = QuestionnaireEntry.getInstance().getqEighteen();
        this.q19 = QuestionnaireEntry.getInstance().getqNineteen();
        this.result = QuestionnaireEntry.getInstance().getResult();
        this.day = DreamDate.getInstance().getDayOfMonth();
        this.month = DreamDate.getInstance().getMonth();
        this.year = DreamDate.getInstance().getYear();
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getMusical() {
        return musical;
    }

    public void setMusical(int musical) {
        this.musical = musical;
    }

    public int getGrayscale() {
        return grayscale;
    }

    public void setGrayscale(int grayscale) {
        this.grayscale = grayscale;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }

    public int getHasPeople() {
        return hasPeople;
    }

    public void setHasPeople(int hasPeople) {
        this.hasPeople = hasPeople;
    }

    public String getFirstPerson() {
        return firstPerson;
    }

    public void setFirstPerson(String firstPerson) {
        this.firstPerson = firstPerson;
    }

    public String getSecondPerson() {
        return secondPerson;
    }

    public void setSecondPerson(String secondPerson) {
        this.secondPerson = secondPerson;
    }

    public String getThirdPerson() {
        return thirdPerson;
    }

    public void setThirdPerson(String thirdPerson) {
        this.thirdPerson = thirdPerson;
    }

    public String getFourthPerson() {
        return fourthPerson;
    }

    public void setFourthPerson(String fourthPerson) {
        this.fourthPerson = fourthPerson;
    }

    public String getFifthPerson() {
        return fifthPerson;
    }

    public void setFifthPerson(String fifthPerson) {
        this.fifthPerson = fifthPerson;
    }

    public String getSixthPerson() {
        return sixthPerson;
    }

    public void setSixthPerson(String sixthPerson) {
        this.sixthPerson = sixthPerson;
    }

    public String getSeventhPerson() {
        return seventhPerson;
    }

    public void setSeventhPerson(String seventhPerson) {
        this.seventhPerson = seventhPerson;
    }

    public String getEighthPerson() {
        return eighthPerson;
    }

    public void setEighthPerson(String eighthPerson) {
        this.eighthPerson = eighthPerson;
    }

    public String getNinthPerson() {
        return ninthPerson;
    }

    public void setNinthPerson(String ninthPerson) {
        this.ninthPerson = ninthPerson;
    }

    public String getTenthPerson() {
        return tenthPerson;
    }

    public void setTenthPerson(String tenthPerson) {
        this.tenthPerson = tenthPerson;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(int physicalActivity) {
        this.physicalActivity = physicalActivity;
    }

    public int getFoodConsumption() {
        return foodConsumption;
    }

    public void setFoodConsumption(int foodConsumption) {
        this.foodConsumption = foodConsumption;
    }

    public int getQ1() {
        return q1;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    public int getQ2() {
        return q2;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    public int getQ3() {
        return q3;
    }

    public void setQ3(int q3) {
        this.q3 = q3;
    }

    public int getQ4() {
        return q4;
    }

    public void setQ4(int q4) {
        this.q4 = q4;
    }

    public int getQ5() {
        return q5;
    }

    public void setQ5(int q5) {
        this.q5 = q5;
    }

    public int getQ6() {
        return q6;
    }

    public void setQ6(int q6) {
        this.q6 = q6;
    }

    public int getQ7() {
        return q7;
    }

    public void setQ7(int q7) {
        this.q7 = q7;
    }

    public int getQ8() {
        return q8;
    }

    public void setQ8(int q8) {
        this.q8 = q8;
    }

    public int getQ9() {
        return q9;
    }

    public void setQ9(int q9) {
        this.q9 = q9;
    }

    public int getQ10() {
        return q10;
    }

    public void setQ10(int q10) {
        this.q10 = q10;
    }

    public int getQ11() {
        return q11;
    }

    public void setQ11(int q11) {
        this.q11 = q11;
    }

    public int getQ12() {
        return q12;
    }

    public void setQ12(int q12) {
        this.q12 = q12;
    }

    public int getQ13() {
        return q13;
    }

    public void setQ13(int q13) {
        this.q13 = q13;
    }

    public int getQ14() {
        return q14;
    }

    public void setQ14(int q14) {
        this.q14 = q14;
    }

    public int getQ15() {
        return q15;
    }

    public void setQ15(int q15) {
        this.q15 = q15;
    }

    public int getQ16() {
        return q16;
    }

    public void setQ16(int q16) {
        this.q16 = q16;
    }

    public int getQ17() {
        return q17;
    }

    public void setQ17(int q17) {
        this.q17 = q17;
    }

    public int getQ18() {
        return q18;
    }

    public void setQ18(int q18) {
        this.q18 = q18;
    }

    public int getQ19() {
        return q19;
    }

    public void setQ19(int q19) {
        this.q19 = q19;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

