package com.phrenologue.dreamcatcherapp.webservice;

import android.util.Log;

import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters.Date;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;

import org.json.JSONException;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiPostCaller {
    public ApiPostCaller() {
    }

    IPostService postService = ApiClient.getRetrofit().create(IPostService.class);

    public void getRemembered(IResponseMessage responseMessage) {
        Users user = Users.getInstance();
        Call<ResponseBody> call = postService.getRemembered(user.getUid());
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

    public void addDateToSleep(IResponseMessage responseMessage) {
        Date date = Date.getInstance();
        Sleep sleep = Sleep.getInstance();
        Users user = Users.getInstance();
        Call<ResponseBody> call = postService.addDateToSleep(user.getUid(), sleep.getPostId(),
                date.getDayOfWeek(), date.getDayOfMonth(), date.getDayOfYear(), date.getWeekOfMonth(),
                date.getMonth(), date.getYear());
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

    public void saveDreamSeparately(IResponseMessage responseMessage) {
        DreamChecklist checklist = DreamChecklist.getInstance();
        DreamPeople people = DreamPeople.getInstance();
        DreamSound sound = DreamSound.getInstance();
        DreamLucidity lucidity = DreamLucidity.getInstance();
        DreamDescription description = DreamDescription.getInstance();
        Users user = Users.getInstance();
        Dream dream = Dream.getInstance();
        Date date = Date.getInstance();
        Call<ResponseBody> call = postService.postDreams(dream.getPostId(), user.getUid(),
                checklist.getRemembered(), people.getName(),
                people.getExistent(), people.getImpression(),
                sound.getSound(), sound.getMusical(),
                checklist.getGrayScale(),
                checklist.getExperience(),
                lucidity.getLucidityLevel(),
                description.getTitle(), description.getContent(),
                date.getDayOfWeek(), date.getDayOfMonth(), date.getDayOfYear(), date.getWeekOfMonth(),
                date.getMonth(), date.getYear());
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

    public void saveSleepSeparately(IResponseMessage responseMessage) {
        Users user = Users.getInstance();
        Sleep sleep = Sleep.getInstance();
        Dream dream = Dream.getInstance();
        Date date = Date.getInstance();
        Call<ResponseBody> call = postService.postSleeps(user.getUid(), sleep.getPostId(), sleep.getDuration(),
                sleep.getTime(), sleep.getPhysicalActivity(), sleep.getFoodConsumption(),
                sleep.getSleepParalysis(), dream.getDreamChecklist().getRemembered(),
                date.getDayOfWeek(), date.getDayOfMonth(), date.getDayOfYear(), date.getWeekOfMonth(),
                date.getMonth(), date.getYear());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("", "");
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

    public void getDailyMood(IResponseMessage responseMessage){
        Call<ResponseBody> call = postService.getDailyMood(Users.getInstance().getUid());
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

    public void getSoundPercent(IResponseMessage responseMessage){
        Call<ResponseBody> call = postService.getSound(Users.getInstance().getUid());
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

    public void getMusicalPercent(IResponseMessage responseMessage){
        Call<ResponseBody> call = postService.getMusical(Users.getInstance().getUid());
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

    public void getGrayScalePercent(IResponseMessage responseMessage){
        Call<ResponseBody> call = postService.getGrayScale(Users.getInstance().getUid());
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

    public void getMoodPercent(IResponseMessage responseMessage){
        Call<ResponseBody> call = postService.getMood(Users.getInstance().getUid());
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

    public void getLucidityPercent(IResponseMessage responseMessage){
        Call<ResponseBody> call = postService.getLucidity(Users.getInstance().getUid());
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

    public void getDreamDescription(IResponseMessage responseMessage){
        Call<ResponseBody> call = postService.getDescription(Users.getInstance().getUid());
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
