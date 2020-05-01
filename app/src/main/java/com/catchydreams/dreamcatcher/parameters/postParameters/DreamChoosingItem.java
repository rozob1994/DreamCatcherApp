package com.catchydreams.dreamcatcher.parameters.postParameters;

import com.catchydreams.dreamcatcher.database.posts.PostsEntity;

import java.util.ArrayList;
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
        if (instance == null) {
            instance = new DreamChoosingItem();
        }
        return instance;
    }

    public void setLists(List<PostsEntity> posts) {
        List<Integer> postIds = new ArrayList<>();
        List<Integer> sleepTimes = new ArrayList<>();
        List<Integer> experiences = new ArrayList<>();
        List<Integer> days = new ArrayList<>();
        List<Integer> months = new ArrayList<>();
        List<Integer> years = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> contents = new ArrayList<>();
        if (posts.size()>0){
            for (int i = 0; i < posts.size(); i++) {
                PostsEntity post = posts.get(i);
                postIds.add(post.getPostId());
                sleepTimes.add(post.getTime());
                experiences.add(post.getExperience());
                days.add(post.getDay());
                months.add(post.getMonth());
                years.add(post.getYear());
                titles.add(post.getTitle());
                contents.add(post.getContent());
            }
            this.postIds = postIds;
            this.sleepTimes = sleepTimes;
            this.experiences = experiences;
            this.days = days;
            this.months = months;
            this.years = years;
            this.titles = titles;
            this.contents = contents;
        }

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
