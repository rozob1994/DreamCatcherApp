package com.phrenologue.dreamcatcherapp.webservice;

import android.util.Log;

import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters.Date;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;

import org.json.JSONException;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCaller {
    Dream dream1;
    Sleep sleep1;
    Users user;
    Date date;

    public ApiCaller() {
    }

    IUserService userService = ApiClient.getRetrofit().create(IUserService.class);


    public void signUp(String user, String pass, int uid, IResponseMessage responseMessage) {
        Call<ResponseBody> call = userService.signUp(user, pass, uid);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }


    public void login(String user, String pass, IResponseMessage responseMessage) {
        Call<ResponseBody> call = userService.login(user, pass);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("", "");

                assert response.body() != null;
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void editUserLevel(IResponseMessage responseMessage){
        Users user = Users.getInstance();
        Call<ResponseBody> call = userService.editLevel(user.getUid(),user.getLevel());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }


}
