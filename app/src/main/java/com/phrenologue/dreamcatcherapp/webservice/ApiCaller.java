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
    IPostService postService = ApiClient.getRetrofit().create(IPostService.class);



    public void savePost(final IResponseMessage responseMessage) {
        dream1 = Dream.getInstance();
        sleep1 = Sleep.getInstance();
        user = Users.getInstance();
        date = Date.getInstance();


        Call<ResponseBody> call = postService.savePost(Users.getInstance().getUid(),
                sleep1.getDuration(), sleep1.getTime(),
                sleep1.getPhysicalActivity(), sleep1.getFoodConsumption(), sleep1.getSleepParalysis(),
                dream1.getDreamChecklist().getRemembered(),
                dream1.getDreamPeople().getName(), dream1.getDreamPeople().isExistent(),
                dream1.getDreamPeople().getImpression(),
                dream1.getDreamSound().isSound(), dream1.getDreamSound().isMusical(),
                dream1.getDreamChecklist().isFalseAwake(), dream1.getDreamChecklist().isGrayScale(),
                dream1.getDreamChecklist().getDailyRelated(), dream1.getDreamChecklist().getExperience(),
                dream1.getDreamLucidity().isLucid(), dream1.getDreamLucidity().getLucidityLevel(),
                dream1.getDreamDescription().getTitle(),
                dream1.getDreamDescription().getContent(), date.getDayOfWeek(), date.getDayOfMonth(),
                date.getDayOfYear(), date.getWeekOfMonth(), date.getMonth(), date.getYear());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("", "");
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());

            }
        });
    }

    public void signUp(String user, String pass, int uid, final IResponseMessage responseMessage) {
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
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
                Log.e("", "");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }


}
