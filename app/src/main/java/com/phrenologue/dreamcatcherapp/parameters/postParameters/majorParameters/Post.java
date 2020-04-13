package com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters;

import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private int experience;
    private int sleepTime;
    private int qResult;
    private int day;
    private int month;
    private int year;
    private String title;
    private String content;

    public Post() {

    }




    public List<Post> getPosts(List<Integer> postIds) {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < postIds.size(); i++) {
            Post post = new Post();
            int postId = postIds.get(i);
            getExperienceAndDateFromDB(postId, post);
            getTimeFromDB(postId, post);
            getQResultsFromDB(postId, post);
            posts.add(post);
        }
        return posts;
    }

    private void getExperienceAndDateFromDB(int postId, Post post) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getDreamProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                post.setExperience(jsonObject.getInt("dreamExperience"));
                post.setDay(jsonObject.getInt("dayOfMonth"));
                post.setMonth(jsonObject.getInt("month"));
                post.setYear(jsonObject.getInt("year"));
                post.setTitle(jsonObject.getString("dreamTitle"));
                post.setContent(jsonObject.getString("dreamContent"));
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }

    private void getTimeFromDB(int postId, Post post) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getSleepProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                post.setSleepTime(jsonObject.getInt("sleepTime"));
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }

    private void getQResultsFromDB (int postId, Post post) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getQResult(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONObject jsonObject = new JSONObject(response.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("0");
                boolean status = jsonObject.getBoolean("status");
                if (status) {
                    int result = jsonArray.getJSONObject(0).getInt("result");
                    post.setqResult(result);
                }
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }


    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public int getqResult() {
        return qResult;
    }

    public void setqResult(int qResult) {
        this.qResult = qResult;
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
}
