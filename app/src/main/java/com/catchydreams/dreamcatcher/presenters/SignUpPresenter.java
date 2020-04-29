package com.catchydreams.dreamcatcher.presenters;

import android.util.Log;

import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.OperationResults;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpPresenter {
    ApiCaller apiCaller;
    Users user;
    OperationResults results;

    public SignUpPresenter() {

    }

    public boolean doSignUp(String username, String pass) {
        results = OperationResults.getInstance();
        user = Users.getInstance();
        apiCaller = new ApiCaller();
        user.generateUid();
        apiCaller.signUp(username, pass, user.getUid(), new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONObject jsonObject = new JSONObject(response.toString());
                boolean status = jsonObject.getBoolean("status");
                String message = jsonObject.getString("message");
                Log.e("", "");
                if (status) {
                    user.setEmail(username);
                    user.setPassword(pass);
                    results.setSuccessfulResults(message);
                } else {
                    results.setFailedResults(message);
                }

            }

            @Override
            public void onFailure(String errorMessage) {

                results.setFailedResults(errorMessage);

            }

        });
        return results.isStatus();
    }
}
