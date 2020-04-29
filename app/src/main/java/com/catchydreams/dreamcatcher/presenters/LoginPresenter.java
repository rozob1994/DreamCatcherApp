package com.catchydreams.dreamcatcher.presenters;

import android.util.Log;

import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.OperationResults;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginPresenter {
    OperationResults results;

    public LoginPresenter() {

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
