package com.catchydreams.dreamcatcher.presenters;

import android.util.Log;

import com.catchydreams.dreamcatcher.database.Database;
import com.catchydreams.dreamcatcher.database.posts.PostsEntity;
import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.OperationResults;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamChecklist;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamDate;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamDescription;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Dream;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Sleep;
import com.catchydreams.dreamcatcher.webservice.ApiCaller;
import com.catchydreams.dreamcatcher.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LoginPresenter {
    OperationResults results;
    public LoginPresenter(){}
    public void savePosts(Database db) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getDreamDescription(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONArray jsonArray = new JSONArray(response.toString());

                ArrayList<JSONArray> jsonArrays = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonArrays.add(jsonArray.getJSONArray(i));
                }
                List<Integer> postIds = new ArrayList<>();
                List<Integer> sleepTimes = new ArrayList<>();
                List<Integer> experiences = new ArrayList<>();
                List<Integer> days = new ArrayList<>();
                List<Integer> months = new ArrayList<>();
                List<Integer> years = new ArrayList<>();
                List<String> titles = new ArrayList<>();
                List<String> contents = new ArrayList<>();

                for (int j = 0; j < jsonArrays.size(); j++) {
                    postIds.add(jsonArrays.get(j).getInt(2));
                    experiences.add(jsonArrays.get(j).getInt(6));
                    sleepTimes.add(jsonArrays.get(j).getInt(12));
                    days.add(jsonArrays.get(j).getInt(8));
                    months.add(jsonArrays.get(j).getInt(9));
                    years.add(jsonArrays.get(j).getInt(10));
                    titles.add(jsonArrays.get(j).getString(0));
                    contents.add(jsonArrays.get(j).getString(1));
                }
                for (int i = 0; i < postIds.size(); i++) {
                    Dream dream = Dream.getInstance();
                    DreamChecklist checklist = DreamChecklist.getInstance();
                    Sleep sleep = Sleep.getInstance();
                    DreamDate date = DreamDate.getInstance();
                    DreamDescription description = DreamDescription.getInstance();
                    dream.setPostId(postIds.get(i));
                    sleep.setTime(sleepTimes.get(i));
                    checklist.setExperience(experiences.get(i));
                    date.setDayOfMonth(days.get(i));
                    date.setMonth(months.get(i));
                    date.setYear(years.get(i));
                    description.setTitle(titles.get(i));
                    description.setContent(contents.get(i));
                    PostsEntity post = new PostsEntity();
                    db.postDao().post(post);
                    Dream.delDream();
                    DreamChecklist.delChecklist();
                    Sleep.delSleep();
                    DreamDate.delDreamDate();
                    DreamDescription.delDescription();
                }

            }

            @Override
            public void onFailure(String errorMessage) {

            }


        });
    }

    public void getAllDreams(){

    }

    public void doLogin(String username, String pass){
        results = OperationResults.getInstance();
        ApiCaller apiCaller = new ApiCaller();
        apiCaller.login(username, pass, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                Users user = Users.getInstance();
                JSONObject jsonObject = new JSONObject(response.toString());
                boolean status = jsonObject.getBoolean("status");
                String message = jsonObject.getString("message");
                if (status){
                    results.setSuccessfulResults(message);
                    user.setEmail(username);
                    int uid = jsonObject.getInt("uid");
                    user.setUid(uid);
                    Log.e("", "");
                } else {
                    results.setFailedResults(message);
                }

            }
            @Override
            public void onFailure(String errorMessage) {
                results.setFailedResults(errorMessage);
            }
        });
    }



}
