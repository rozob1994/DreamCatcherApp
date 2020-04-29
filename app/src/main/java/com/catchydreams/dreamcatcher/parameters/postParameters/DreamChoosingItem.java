package com.catchydreams.dreamcatcher.parameters.postParameters;

import java.util.List;

public class DreamChoosingItem {
    private static DreamChoosingItem instance = null;
    private List<Integer> postIds;
    private List<Integer> sleepTimes;
    private List<Integer> experiences;
    private List<Integer> days;
    private List<Integer> months;
    private List<Integer> years;
    private List<String> titles;
    private List<String> contents;

    public static DreamChoosingItem getInstance() {
        if (instance == null){
            instance = new DreamChoosingItem();
        }
        return instance;
    }

    public List<Integer> getPostIds() {
        return postIds;
    }

    public void setPostIds(List<Integer> postIds) {
        this.postIds = postIds;
    }

    public List<Integer> getSleepTimes() {
        return sleepTimes;
    }

    public void setSleepTimes(List<Integer> sleepTimes) {
        this.sleepTimes = sleepTimes;
    }

    public List<Integer> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Integer> experiences) {
        this.experiences = experiences;
    }

    public List<Integer> getDays() {
        return days;
    }

    public void setDays(List<Integer> days) {
        this.days = days;
    }

    public List<Integer> getMonths() {
        return months;
    }

    public void setMonths(List<Integer> months) {
        this.months = months;
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }
}
