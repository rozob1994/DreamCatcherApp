package com.phrenologue.dreamcatcherapp.presenters;

import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.webservice.ApiCaller;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class PostPresenter {
    private static ApiCaller apiCaller;
    private static ApiPostCaller postCaller;


    public static void retrieveAllDreamsDaily() {
        postCaller = new ApiPostCaller();
        Users user = Users.getInstance();
        postCaller.getDreamsDaily(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONObject jsonObject = new JSONObject(response.toString());

            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }
}
